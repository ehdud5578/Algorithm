package BOJ_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L,C;
    static char[] password;
    static boolean[][] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(stz.nextToken());
        C = Integer.parseInt(stz.nextToken());
        password = new char[C];
        visited = new boolean[C][2];
        stz = new StringTokenizer(br.readLine());
        for(int i = 0;i<C;i++){
            password[i] = stz.nextToken().toCharArray()[0];
        }
        Arrays.sort(password);
        for (int i = 0;i<C;i++){
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
                visited[i][1] = true;
            }
        }
        dfs(0,0);
        System.out.println(sb.toString());
    }
    public static void dfs(int cnt, int n){
        if(cnt == L){
            StringBuilder stringBuilder = new StringBuilder();
            boolean check = false;
            int cntnum = 0;
            for(int i = 0;i<C;i++){
                if(visited[i][0]){
                    stringBuilder.append(password[i]);
                    if (visited[i][1])
                        check = true;
                    else
                        cntnum++;
                }
            }
            if (check && cntnum>=2)
                sb.append(stringBuilder + "\n");
            return;
        }
        for(int i = n;i<C;i++){
            if(visited[i][0])
                continue;
            visited[i][0] = true;
            dfs(cnt +1,i);
            visited[i][0] = false;
        }
    }
}
