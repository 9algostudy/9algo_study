package 이은지.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667_단지번호붙이기 {

	static int N, total, cnt;
	static int[][] map;
	static boolean[][] visited;

	static ArrayList<Integer> result;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					dfs(i, j);
					result.add(cnt);
					total++;
				}
			}
		}

		Collections.sort(result);

		System.out.println(total);
		for (int i = 0; i < total; i++) {
			System.out.println(result.get(i));
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 1 || visited[nx][ny]) {
				continue;
			}

			cnt++;
			dfs(nx, ny);
		}
	}

}
