package 이은지.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노{

	static int N, M, max, sum;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				sum = map[i][j];
				bfs(i, j, 1);
				visited[i][j] = false;

				sum = map[i][j];
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}

					sum += map[nx][ny];
				}

				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}

					sum -= map[nx][ny];
					max = Math.max(max, sum);
				}

			}
		}

		System.out.println(max);

	}


	private static void bfs(int x, int y, int idx) {
		if (idx == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
				visited[nx][ny] = true;
				sum += map[nx][ny];
				bfs(nx, ny, idx + 1);
				visited[nx][ny] = false;
				sum -= map[nx][ny];
			}
		}
	}

}
