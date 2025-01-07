package 윤다은.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589_보물섬 {
    static char[][] map;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        map = new char[n][m];
        String st;
        for (int i = 0; i < n; i++) {
            st = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = st.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') findLongest(i, j);
            }
        }

        System.out.println(res);
    }

    static void findLongest(int r, int c) {
        int[][] visited = new int[n][m];
        visited[r][c] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] > 0 || map[nr][nc] == 'W') continue;
                visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
                max = Math.max(max, visited[nr][nc]);
                queue.add(new int[]{nr, nc});
            }
        }

        res = Math.max(res, max-1);
    }
}
