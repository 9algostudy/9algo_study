package 박성욱.week13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기 {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    static List<Integer> result = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    int size = dfs(i, j);
                    result.add(size);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int size : result) {
            System.out.println(size);
        }
    }

    public static int dfs(int i, int j) {
        visit[i][j] = true;
        int size = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nr = i + dr[dir];
            int nc = j + dc[dir];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && arr[nr][nc] == 1) {
                size += dfs(nr, nc);
            }
        }

        return size;
    }
}
