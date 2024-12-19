package 박성욱.week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14940_쉬운최단거리 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().trim().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        int startx = 0;
        int starty = 0;

        for (int i = 0; i < n; i++) {
            String String1[] = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String1[j]);
                if (arr[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
            }
        }

        bfs(startx, starty);

        for (int[] arr1 : arr) {
            for (int x : arr1) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int starti, int startj) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starti, startj});
        visited[starti][startj] = true;
        arr[starti][startj] = 0; 

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int x = now[0];
            int y = now[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] + 1;  
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = -1;
                }
            }
        }
    }
}
