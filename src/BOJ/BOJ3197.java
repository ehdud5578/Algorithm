package BOJ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int r,c;
    static char[][] lake;
    static Queue<int[]> water,queue;
    static int[] dx,dy;
    static Point start,end;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        dx = new int[]{0,1,0,-1};
        dy = new int[]{1,0,-1,0};
        lake = new char[r][c];
        water = new LinkedList<>();
        visited = new boolean[r][c];
        queue = new LinkedList<>();
        boolean check = false;
        for(int i = 0;i<r;i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0;j<c;j++){
                lake[i][j] = temp[j];
                if(temp[j] == 'L'){
                    if(!check){
                        start = new Point(j,i);
                        check = true;
                    }
                    else
                        end = new Point(j,i);
                    lake[i][j] = '.';
                }else if(temp[j] == '.'){
                    water.add(new int[]{j,i});
                }
            }
        }
        queue.add(new int[]{start.x,start.y});
        visited[start.y][start.x] = true;
        int result = 0;
        while (!isConnected()){
            result++;
            meltice();
        }
        System.out.println(result);
    }

    public static void meltice(){
        int size = water.size();
        for(int i = 0;i<size;i++){
            int[] now = water.poll();
            for(int j = 0;j<4;j++){
                int ny = now[1] + dy[j];
                int nx = now[0] + dx[j];
                if(nx>=0&&nx<c&&ny>=0&&ny<r && lake[ny][nx] == 'X'){
                    water.add(new int[]{nx,ny});
                    lake[ny][nx] = '.';
                }
            }
        }
    }

    public static boolean isConnected(){
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==end.x && now[1] ==end.y)
                return true;
            for(int i = 0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0&&nx<c&&ny>=0&&ny<r){
                    if(!visited[ny][nx]&& lake[ny][nx] == '.') { // 방문하지 않았고 물일때 계속 탐색
                        queue.add(new int[]{nx,ny});
                        visited[ny][nx] = true;
                    } else{
                        nextQueue.add(new int[]{nx,ny}); // 얼음일 경우 다음턴부터 탐색 함.
                        visited[ny][nx] = true;
                    }
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
* */