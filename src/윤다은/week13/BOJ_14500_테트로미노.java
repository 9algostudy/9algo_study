package 윤다은.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노{
	static int[][] map, visited;
	static int[][] curList = new int[4][2];
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i%2; j < M; j+=2) {
				visited[i][j] = 1;
				curList[0][0] = i;
				curList[0][1] = j;
				tet(1, map[i][j]);
				visited[i][j] = 0;
			}
		}

		System.out.println(max);
	}

	static void tet(int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int j = 0; j < depth; j++) {
			for (int i = 0; i < 4; i++) {
				int newx = curList[j][0] + dir[i][0];
				int newy = curList[j][1] + dir[i][1];

				if (newx < 0 || newx >= N || newy < 0 || newy >= M || visited[newx][newy] == 1) continue;

				visited[newx][newy] = 1;
				curList[depth][0] = newx;
				curList[depth][1] = newy;
				tet(depth+1, sum+map[newx][newy]);
				visited[newx][newy] = 0;
			}
		}
	}
}
