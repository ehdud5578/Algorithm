package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> array = new HashSet<>();
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int a = Integer.parseInt(stz.nextToken());
            array.add(a);
        }
        int m = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        for (int i = 0;i<m;i++){
            int temp = Integer.parseInt(stz.nextToken());
            if(array.contains(temp))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
