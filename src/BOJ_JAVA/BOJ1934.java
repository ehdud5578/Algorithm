package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1934 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        int a,b,gcd,an,bn;
        StringTokenizer stz;
        for(int i = 0;i<testcase;i++){
            stz = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stz.nextToken());
            b = Integer.parseInt(stz.nextToken());
            if(a>b){
                gcd = gcd(a,b);
            }else{
                gcd = gcd(b,a);
            }
            an = a/gcd;
            bn = b/gcd;
            long answer = (long) gcd * an * bn;
            bw.write(answer + "\n");
        }
        bw.flush();
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }else if(a%b==0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }
}
