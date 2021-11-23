package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] board;
    static boolean[][] visited;
    static int result, N, M;
    static int[] ny, nx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testecase = Integer.parseInt(br.readLine());
        ny = new int[]{0, 1, 0, -1};
        nx = new int[]{1, 0, -1, 0};
        for (int i = 0; i < testecase; i++) {
            result = 0;
            StringTokenizer stz = new StringTokenizer(br.readLine());
            int K;
            M = Integer.parseInt(stz.nextToken());
            N = Integer.parseInt(stz.nextToken());
            K = Integer.parseInt(stz.nextToken());
            board = new int[N][M];  // 가로 M 세로 N
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                stz = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(stz.nextToken());
                int Y = Integer.parseInt(stz.nextToken());
                board[Y][X] = 1;
            }
            for (int dx = 0; dx < M; dx++) {
                for (int dy = 0; dy < N; dy++) {
                    if (!visited[dy][dx] && (board[dy][dx] == 1)) {
                        result += 1;
                        dfs(dy, dx);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int dy, int dx) {
        visited[dy][dx] = true;
        for (int i = 0; i < 4; i++) {
            int nexty = dy + ny[i];
            int nextx = dx + nx[i];
            if (nexty >= 0 && nexty < N && nextx >= 0 && nextx < M && !visited[nexty][nextx] && board[nexty][nextx] == 1) {
                dfs(nexty, nextx);
            }
        }
    }
}
