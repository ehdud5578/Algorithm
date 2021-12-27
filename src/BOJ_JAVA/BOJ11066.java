package BOJ_JAVA;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11066 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] list = new int[K+1];
            int[] sum = new int[K+1];
            int[][] dp = new int[K+1][K+1];
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                list[j] = Integer.parseInt(stz.nextToken());
                sum[j] = sum[j-1] + list[j];
            }
            for (int n = 1;n<=K;n++){
                for (int from = 1;from + n<=K;from++){
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide = from;divide<to;divide++){
                        dp[from][to] = Math.min(dp[from][to],dp[from][divide] + dp[divide+1][to] + sum[to] - sum[from -1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
        }
    }

}
