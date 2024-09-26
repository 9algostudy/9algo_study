package 박성욱.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2468_안전영역 {
	static int[][] arr;
	static int n, max, maxcnt;
	static boolean[][] visit;
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		max = 0;
		maxcnt = 0;
		for (int i = 0; i < arr.length; i++) {
			String str[] = br.readLine().trim().split(" ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int h = 0; h < max; h++) {
			visit = new boolean[n][n];
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > h && !visit[i][j]) {
						check(i, j, h);
						cnt++;
					}
				}
			}
			maxcnt = Math.max(cnt, maxcnt);
		}
		System.out.println(maxcnt);
	}

	private static void check(int i, int j, int h) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { i, j });
		visit[i][j] = true;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int r = now[0];
			int c = now[1];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && visit[nr][nc] == false && arr[nr][nc] > h) {
					visit[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}

	}
}
