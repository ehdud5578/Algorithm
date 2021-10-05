package BOJ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int r,c;
    static String[][] lake;
    static ArrayList<Point> swan,water;
    static int[] dx,dy;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        dx = new int[]{0,1,0,-1};
        dy = new int[]{1,0,-1,0};
        lake = new String[r][c];
        swan = new ArrayList<>();
        water = new ArrayList<>();
        for(int i = 0;i<r;i++){
            String[] temp = br.readLine().split("");
            for(int j = 0;j<c;j++){
                lake[i][j] = temp[j];
                if(temp[j].equals("L")){
                    swan.add(new Point(j,i));
                }else if(temp[j].equals(".")){
                    water.add(new Point(j,i));
                }
            }
        }
        int result = countDays(0);
        System.out.println(result);
    }
    public static int countDays(int day){
        while (!isConnected()){
            day ++;
            meltice();
        }
        return day;

    }
    public static void meltice(){
        Queue<Point> queue = new LinkedList<>(water);
        while (!queue.isEmpty()){
            Point now = queue.poll();
            for(int i = 0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0&&nx<c&&ny>=0&&ny<r){
                    if(lake[ny][nx].equals("X")){
                        water.add(new Point(nx,ny));
                        lake[ny][nx] = ".";
                    }
                }
            }
        }
    }

    public static boolean isConnected(){
        boolean[][] visited = new boolean[r][c];
        Queue<Point> queue = new LinkedList<>();
        queue.add(swan.get(0));
        Point start = swan.get(0);
        Point end = swan.get(1);
        visited[start.y][start.x] = true;
        while (!queue.isEmpty()){
            Point now = queue.poll();
            if(now.x==end.x && now.y ==end.y)
                return true;
            for(int i = 0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0&&nx<c&&ny>=0&&ny<r){
                    if(!visited[ny][nx]&&!lake[ny][nx].equals("X")){
                        queue.add(new Point(nx,ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return false;
    }
}
/*시간초과 2%
* 어디서 시간이 오래 걸리는지 모르겠음.
* */