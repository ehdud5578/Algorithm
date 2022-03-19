package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a, b;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        String[] aa = input.split(" ");
        a = Integer.parseInt(aa[0]);
        b = Integer.parseInt(aa[1]);
        list = new int[9];
        visited = new boolean[9];

        /* dfs 시간측정 */
        long start = System.currentTimeMillis();
        dfs(0);
        long end = System.currentTimeMillis();
        long dfs_Term = end - start;
        System.out.println(dfs_Term);

        /* 비트 마스크를 이용해서 시간 측정*/

    }

    private static void dfs(int count) {
        if (count == b) {
            for (int i = 0; i < b; i++) {
                System.out.printf(list[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < a; i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true;
            list[count] = i + 1;
            dfs(count + 1);
            visited[i] = false;
        }
    }
}