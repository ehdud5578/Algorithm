package BOJ_JAVA.practice_5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    static int[] array,dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt,0);
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            array[i] = Integer.parseInt(stz.nextToken());
        }
        for(int i = 0;i<n;i++){
            lis(i);
        }
        int result = 0;
        for(int i = 0;i<n;i++){
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
    public static int lis(int n){
        if(dp[n]==0){
            dp[n] = 1;
            for(int i = n-1;i>=0;i--){
                if(array[i]<array[n]){
                    dp[n] = Math.max(dp[n] ,lis(i) + 1);
                }
            }
        }
        return dp[n];
    }
}
