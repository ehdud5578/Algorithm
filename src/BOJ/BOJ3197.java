package BOJ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int r, c;
    static char[][] lake;
    static Queue<int[]> water, queue;
    static int[] dx, dy;
    static Point start, end;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        dx = new int[]{0, 1, 0, -1};
        dy = new int[]{1, 0, -1, 0};
        lake = new char[r][c];
        water = new LinkedList<>();
        visited = new boolean[r][c];
        queue = new LinkedList<>();
        boolean check = false;
        for (int i = 0; i < r; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                lake[i][j] = temp[j];
                if (temp[j] == 'L') {
                    if (!check) {
                        start = new Point(j, i);
                        check = true;
                    } else
                        end = new Point(j, i);
                    lake[i][j] = '.';
                }
                if (lake[i][j] == '.') {
                    water.add(new int[]{j, i});
                }
            }
        }
        queue.add(new int[]{start.x, start.y});
        visited[start.y][start.x] = true;
        int result = 0;
        while (!isConnected()) {
            result++;
            meltice();
        }
        System.out.println(result);
    }

    public static void meltice() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            int[] now = water.poll();
            for (int j = 0; j < 4; j++) {
                int ny = now[1] + dy[j]; // NullPointerException 경고.
                int nx = now[0] + dx[j];
                if (nx >= 0 && nx < c && ny >= 0 && ny < r && lake[ny][nx] == 'X') {
                    water.add(new int[]{nx, ny});
                    lake[ny][nx] = '.';
                }
            }
        }
    }

    public static boolean isConnected() {
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == end.x && now[1] == end.y)
                return true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < c && ny >= 0 && ny < r && !visited[ny][nx]) {
                    if (lake[ny][nx] == '.') { // 방문하지 않았고 물일때 계속 탐색
                        queue.add(new int[]{nx, ny});
                    }
                    if (lake[ny][nx] == 'X') {
                        nextQueue.add(new int[]{nx, ny}); // 얼음일 경우 다음턴부터 탐색 함.
                    }
                    visited[ny][nx] = true;
                }
            }
        }
        queue = nextQueue;
        return false;
    }
}
/*시간초과 2%
* 어디서 시간이 오래 걸리는지 모르겠음.
*
* 시간초과 5%
*
* 메모리 초과...
* 다른사람들 블로그와 비교해 봐도 왜 틀렸는지 모르겠다
* 핵심로직이나 매소드 등이 거의 비슷하지만 난 메모리 초과이다.
*
* https://herong.tistory.com/entry/BOJ-3197-%EB%B0%B1%EC%A1%B0%EC%9D%98-%ED%98%B8%EC%88%98-Java
* if(nx>=0&&nx<c&&ny>=0&&ny<r ){
                    if(!visited[ny][nx]&&lake[ny][nx] == '.') { // 방문하지 않았고 물일때 계속 탐색
                        queue.add(new int[]{nx,ny});
                    } else if(lake[ny][nx] == 'X'){
                        nextQueue.add(new int[]{nx,ny}); // 얼음일 경우 다음턴부터 탐색 함.
                    }
                    visited[ny][nx] = true;
                }
               * 이렇게 될 경우 방문했던 곳을 계속해서 체크하기 때문에 잘못된 방법이었다.
* * 55% 실패
* 처음에 입력을 받는 과정에서 백조가 있는 자리를 start , end 에 저장을 한뒤
* 물이 있는곳으로 넣어줘야하는데 그 과정을 빠뜨려서 오래걸림...
* 오늘또한 멍청한 실수를 했기 때문에 오래걸렸다...
*
* */