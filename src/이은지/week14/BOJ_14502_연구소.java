package 이은지.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	static int N, M, zero, max;
	static int[][] graph;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int pos =  Integer.parseInt(st.nextToken());
				graph[i][j] = pos;
				if (pos == 0) {
					zero++;
				}
			}
		}

		max = 0;
		zero -= 3;

		comb(0);

		System.out.println(max);
	}

	private static void comb(int depth) {
		if (depth == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					graph[i][j] = 1;
					comb(depth + 1);
					graph[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int cnt = zero;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 2) {
					q.offer(new int[]{i, j});
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || graph[nx][ny] != 0) {
					continue;
				}

				q.offer(new int[]{nx, ny});
				visited[nx][ny] = true;
				cnt--;
			}
		}

		max = Math.max(max, cnt);
	}

}
