package algo2022.august;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21608 {
    public static int N;
    public static int[][] classRoom;
    public static Students[] students;
    public static int[] dy, dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new Students[(N * N) + 1];
        classRoom = new int[N + 1][N + 1];
        dy = new int[]{0, 1, 0, -1};
        dx = new int[]{1, 0, -1, 0};
        StringTokenizer stz;
        for (int i = 0; i < N * N; i++) {
            stz = new StringTokenizer(br.readLine());
            Students student = new Students();
            student.setNum(Integer.parseInt(stz.nextToken()));
            int[] like = new int[4];
            for (int j = 0; j < 4; j++) {
                like[j] = Integer.parseInt(stz.nextToken());
            }
            student.setLike(like);
            students[student.getNum()] = student;
            setLocation(student.getNum());
        }
        int score = 0;
        for (int i = 1;i<=N;i++){
            for (int j = 1;j<=N;j++){
                int num = classRoom[i][j];
                int likeFriendCnt = 0;
                int[] likes = students[num].getLike();
                for(int k = 0;k<4;k++){
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    if (isArranged(nextY,nextX)){
                        for (int friendNumber : likes){
                            if (classRoom[nextY][nextX] == friendNumber){
                                likeFriendCnt++;
                            }
                        }
                    }
                }
                score += getScore(likeFriendCnt);
            }
        }
        System.out.println(score);
    }
    public static int getScore(int cnt){
        if (cnt ==0)
            return 0;
        if (cnt == 1)
            return 1;
        if (cnt == 2)
            return 10;
        if (cnt == 3)
            return 100;
        return 1000;
    }
    public static void setLocation(int i) {
        int[][] priorities = new int[N + 1][N + 1];
        for (int index = 0;index < 4;index ++) {
            int k = students[i].getLike()[index];
            if (students[k] != null) { // 좋아하는 친구의 위치가 있을 때만 탐색
                Point friendLocation = students[k].getLocation();
                for (int j = 0; j < 4; j++) {
                    int nextY = friendLocation.getY() + dy[j];
                    int nextX = friendLocation.getX() + dx[j];
                    if (isArranged(nextY, nextX) && classRoom[nextY][nextX] == 0){ // 0일때 빈칸
                        priorities[nextY][nextX]++;
                    }
                }
            }
        }
        // find max priorities
        int maxPriority = 0;
        for (int j = 1; j <= N;j++){
            for (int k = 1;k <=N;k++){
                maxPriority = Math.max(maxPriority, priorities[j][k]);
            }
        }

        // find final location -> 주변 빈칸의 수가 가장 많은 곳
        int cnt = -1;
        Point point = new Point(0,0);
        for (int j = 1; j <= N;j++){
            for (int k = 1;k <=N;k++){
                if (priorities[j][k] == maxPriority && classRoom[j][k] == 0){
                    int thisCnt = 0;
                    for (int l = 0;l < 4;l++){
                        int nextY = j + dy[l];
                        int nextX = k + dx[l];
                        if (isArranged(nextY, nextX) && classRoom[nextY][nextX] == 0){
                            thisCnt++;
                        }
                    }
                    if (thisCnt > cnt){
                        cnt = thisCnt;
                        point.setX(k);
                        point.setY(j);
                    }
                }
            }
        }
        classRoom[point.getY()][point.getX()] = i;
        students[i].setLocation(point);
    }
    public static boolean isArranged(int y, int x){
        return y > 0 && y <= N && x > 0 && x <= N;
    }
    public static class Students {
        private int num;
        private int[] like;
        private Point location;

        public Students() {
        }

        public Students(int num, int[] like, Point location) {
            this.num = num;
            this.like = like;
            this.location = location;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int[] getLike() {
            return like;
        }

        public void setLike(int[] like) {
            this.like = like;
        }

        public Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            this.location = location;
        }
    }

    public static class Point {
        private int x;
        private int y;

        public Point() {
        }

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}

