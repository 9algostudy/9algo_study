package 이은지.week12;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {

	static int N, M, tx, ty;
	static int[][] graph;
	static int[][] result;
	static boolean[][] visited;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;

				if (num == 2) {
					tx = i;
					ty = j;
					result[i][j] = 0;
					visited[i][j] = true;
				}

				if (num == 0) {
					visited[i][j] = true;
				}
			}
		}

		bfs(tx, ty);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					result[i][j] = -1;
				}

				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});

		while(!q.isEmpty()) {
			int[] pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || graph[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}

				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				result[nx][ny] = result[pos[0]][pos[1]] + 1;

			}
		}
	}

}

