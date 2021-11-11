package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11401 {
    static int n;
    static int MOD = 1_000_000_007;
    static int[][] array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int a = factorial(n);
        int b = factorial(k);
        int c = factorial(n-k);
        int d = power(b,MOD-2);
        int e = power(c,MOD-2);
        long answer1 = ((long) a * d)%MOD;
        long answer2 = (answer1 * e) % MOD;
        System.out.println(answer2);
    }
    static int power(long x,int y){
        long answer = 1;
        while (y>0){
            if(y%2==1){
                answer = (answer * x) % MOD;
            }
            x = (x*x)%MOD;
            y = y/2;
        }
        return (int) answer;
    }

    static int factorial(int n){
        long answer = 1;
        for(int i = 2;i<=n;i++){
            answer = (answer * i)%MOD;
        }
        return (int) answer;
    }
}

