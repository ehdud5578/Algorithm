package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2193 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] sum = new long[92][2];
        sum[1][0] = 0;
        sum[1][1] = 1;
        for(int i = 2;i<=n;i++){
            sum[i][0] = sum[i-1][1] + sum[i-1][0];
            sum[i][1] = sum[i-1][0];
        }
        long result = sum[n][0] + sum[n][1];
        System.out.println(result);
    }
}

//결과값이 int 형으로 부족해서 실패 했었음.
