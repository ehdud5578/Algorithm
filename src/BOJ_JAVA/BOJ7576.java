package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ7576 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int highn,widthm,cntzero,days;
        widthm = Integer.parseInt(temp[0]);
        cntzero = 0;
        days = 0;
        int[] dy = new int[]{0,1,0,-1}; // 동 남 서 북
        int[] dx = new int[]{1,0,-1,0};
        highn = Integer.parseInt(temp[1]);
        int[][] board = new int[highn][widthm];
        boolean[][] visited = new boolean[highn][widthm];
        for(int i = 0;i<highn;i++){
            temp = br.readLine().split(" ");
            for(int j = 0;j<widthm;j++){
                board[i][j] = Integer.parseInt(temp[j]);
                if(board[i][j]==0)
                    cntzero ++;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<highn;i++){
            for(int j = 0;j<widthm;j++){
                if(board[i][j]==1&&!visited[i][j]){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        Queue<int[]> nextque = new LinkedList<>();
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nexty = next[0] + dy[k];
                int nextx = next[1] + dx[k];
                if (nexty >= 0 && nexty < highn && nextx >= 0 && nextx < widthm) {
                    if (board[nexty][nextx] == 0&&!visited[nexty][nextx]) {
                        board[nexty][nextx] = 1;
                        visited[nexty][nextx] = true;
                        cntzero--;
                        nextque.add(new int[]{nexty, nextx});
                    }
                }
            }
            if(queue.isEmpty()){
                if(!nextque.isEmpty())
                    days++;
                while (!nextque.isEmpty()){
                    queue.add(nextque.poll());
                }
            } // 이 부분에서 다른사람들보다 시간과 메모리를 아낄 수 있었다.
        }
        if(cntzero==0)
            System.out.println(days);
        else
            System.out.println("-1");

    }
}
