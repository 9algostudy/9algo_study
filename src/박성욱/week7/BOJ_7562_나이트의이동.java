package 박성욱.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562_나이트의이동 {
    static int dr [] = {-2,-1,1,2,2,1,-1,-2};
    static int dc [] = {1,2,2,1,-1,-2,-2,-1};
    static boolean [][] visit;
    static int nowr, nowc;
    static int tarr, tarc;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            visit = new boolean[n][n];

            String nowstr [] = br.readLine().trim().split(" ");
            nowr = Integer.parseInt(nowstr[0]);
            nowc = Integer.parseInt(nowstr[1]);

            String tarstr [] = br.readLine().trim().split(" ");
            tarr = Integer.parseInt(tarstr[0]);
            tarc = Integer.parseInt(tarstr[1]);

            System.out.println(bfs(nowr, nowc));
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j, 0});  
        visit[i][j] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int cnt = now[2];

            if(r == tarr && c == tarc) {
                return cnt;
            }

            for(int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    q.add(new int[] {nr, nc, cnt + 1});
                }
            }
        }
        return -1;  
    }
}
