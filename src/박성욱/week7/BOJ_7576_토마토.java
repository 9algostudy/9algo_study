package 박성욱.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_토마토 {
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int arr[][];
	static boolean visit[][];
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nmarr[] = br.readLine().trim().split(" ");
		m = Integer.parseInt(nmarr[0]);
		n = Integer.parseInt(nmarr[1]);
		arr = new int[n][m];
		for(int i = 0;i<n;i++) {
			String str[] = br.readLine().trim().split(" ");
			for(int j = 0;j<m;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
        visit = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) { 
                    q.add(new int[] {i, j});
                    visit[i][j] = true;
                }
            }
        }
        bfs(q);
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {  
                    System.out.println(-1);
                    return;
                }
                res = Math.max(res, arr[i][j]);
            }
        }

        System.out.println(res - 1);
    }


    private static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int now[] = q.poll();
            int r = now[0];
            int c = now[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc] && arr[nr][nc] == 0) { 
                    arr[nr][nc] = arr[r][c] + 1; 
                    visit[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
