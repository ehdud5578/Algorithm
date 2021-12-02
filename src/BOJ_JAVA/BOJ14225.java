package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14225 {
    static boolean[] array;
    static int N;
    static int[] numList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numList = new int[N];
        array = new boolean[20 * 100000];
        Arrays.sort(numList);
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            numList[i] = Integer.parseInt(stz.nextToken());
        }
        solve(0,0);
        int start = 0;
        while(true){
            if(!array[start]){
                System.out.println(start);
                return;
            }
            start++;
        }
    }
    public static void solve(int n, int sum){
        if(n == N){
            array[sum] = true;
            return;
        }
        solve(n+1 , sum + numList[n]);
        solve(n+1,sum);
    }
}
