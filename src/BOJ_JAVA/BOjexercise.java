package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOjexercise {
    static int[] belt;
    static boolean[] robot;
    static int n,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken()); // cin
        int result = 0;
        belt = new int[2 * n];
        robot = new boolean[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(stz.nextToken());
            if(belt[i] == 0)
                k--;
        }
        // 알고리즘 시작
        while(k>0){
            movebelt();
            moverobot();
            result++;
        }
        System.out.println(result);
    }

    public static void movebelt() {
        int temp = belt[2 * n - 1];
    }

    public static void moverobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] == true && belt[i] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i]--;
                if(belt[i] == 0)
                    k--;
            }
        }

        for(int i = 0;i<2*n;i++){
            if (robot[i] == true && belt[i] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i]--;
                if(belt[i] == 0)
                    k--;
            }
        }
    }
}
