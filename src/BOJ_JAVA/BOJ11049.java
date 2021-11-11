package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11049 {
    static int[][] dp,matrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[n][n];
        StringTokenizer stz;
        for(int i = 0;i<n;i++){
            stz = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(stz.nextToken());
            matrix[i][1] = Integer.parseInt(stz.nextToken());
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int answer = solve(0,n-1);
        System.out.println(answer);
    }
    public static int solve(int start,int end){
        if(start == end) return 0;
        if(dp[start][end]!=Integer.MAX_VALUE){
            return dp[start][end];
        }
        for(int i = start;i<end;i++){
            int cost = solve(start,i) + solve(i+1,end) + matrix[start][0] * matrix[i][1] * matrix[end][1];
            dp[start][end] = Math.min(dp[start][end],cost);
        }
        return dp[start][end];
    }
}

// 동적프로그래밍 문제
// dp 문제인지 모르고 재귀함수로 구현했더니 실패했다.
// 반복문으로 해결하는 방법이 있다.
//
//for(int i=1; i<n; i++) {
//        for(int j=0; j<n-i; j++) {
//        dp[j][j+i] = Integer.MAX_VALUE;
//        for(int k=0; k<i; k++) {
//        int cost = dp[j][j+k] + dp[j+k+1][j+i] + a[j][0] * a[j+k][1] * a[j+i][1];
//        dp[j][j+i] = Math.min(dp[j][j+i], cost);
//        }
//        }
//        }
//
//
//        출처: https://dundung.tistory.com/115 [DunDung]
