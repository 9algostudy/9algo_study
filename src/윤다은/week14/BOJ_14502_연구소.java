package 윤다은.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N, M;
	static int[][] lab;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][M];
		min = N*M;

		int cnt = -3;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) cnt++;
			}
		}

		makeWall(0);
		System.out.println(cnt-min);
	}

	static void makeWall(int depth) {
		if (depth == 3) {
			searchVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					makeWall(depth+1);
					lab[i][j] = 0;
				}
			}
		}
	}

	static void searchVirus() {
		int[][] visited = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 2) {
					queue.offer(new int[]{i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newx = tmp[0] + dir[i][0];
				int newy = tmp[1] + dir[i][1];

				if (newx < 0 || newx >= N || newy < 0 || newy >= M || visited[newx][newy] == 1) continue;

				if (lab[newx][newy] == 0) {
					visited[newx][newy] = 1;
					cnt++;
					queue.offer(new int[]{newx, newy});
				}
			}
		}

		min = Math.min(min, cnt);
	}
}
