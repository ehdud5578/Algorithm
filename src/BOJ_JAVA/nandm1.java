package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nandm1 {
    public static int n,m;
    public static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        boolean[] checked= new boolean[5]; //    1 , 2 , 3 , 4
        for (int i = 1; i <= 4; i++) {       //true true ture
            if(checked[i])
                continue;
            checked[i] = true;
            for (int j = 1; j <= 4; j++) {
                if(checked[j])
                    continue;
                checked[j] = true;
                for (int k = 1; k <= 4; k++) {
                    if(checked[k])
                        continue;
                    checked[k] = true;
                    for (int q = 1; q <= 4; k++) {
                        if(checked[q])
                            continue;
                        checked[q] = true;
                        //asdfasdfasdfasdfasdfasdf;
                        checked[q] = false;
                    }
                    checked[k] = false;
                }
                checked[j] = false;
            }
            checked[i] = false;
        }
    }

    public static void dfs(){

    }
}
