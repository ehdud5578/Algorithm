package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1309 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 3;
        if(n>1){
            for(int i = 2;i<=n;i++){
                array[i] = (array[i-1]* 2 + array[i-2])%9901;
            }
        }
        System.out.println(array[n]);
    }
}
