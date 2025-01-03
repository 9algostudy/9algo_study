package 박성욱.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int safearea = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().trim().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		dfs(0);

		System.out.println(safearea);

	}

	private static void dfs(int wall) {
		if (wall == 3) {
			int area = bfs();
			safearea = Math.max(area, safearea);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(wall + 1);
					arr[i][j] = 0;
				}
			}
		}

	}

	private static int bfs() {

		int[][] temparr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temparr[i][j] = arr[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temparr[i][j] == 2) {
					q.add(new int[]{i, j});
				}
			}
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowr = now[0], nowc = now[1];
			for (int k = 0; k < 4; k++) {
				int nr = nowr + dr[k];
				int nc = nowc + dc[k];
				if (nr >= 0 && nc >= 0 && nr < n && nc < m && temparr[nr][nc] == 0) {
					temparr[nr][nc] = 2;
					q.add(new int[]{nr, nc});
				}
			}
		}
		int safearea = 0;
		for(int i =0;i<n;i++){
			for(int j =0;j<m;j++){
				if(temparr[i][j] ==0){
					safearea++;
				}
			}
		}


		return safearea;
	}
}

