package 이은지.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0);

	}

	private static void recur(int x, int y) {

		if (y == 9) {
			recur(x + 1, 0);
			return;
		}

		if (x == 9) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 9; i++) {

				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}

			System.out.println(sb);
			System.exit(0);
		}

		if (map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {

				if (!check(x, y, i)) {
					continue;
				}

				map[x][y] = i;
				recur(x, y + 1);
			}

			map[x][y] = 0;
			return;
		}

		recur(x, y + 1);
	}

	private static boolean check(int x, int y, int num) {

		//가로 탐색
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num) {
				return false;
			}
		}

		//세로 탐색
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num) {
				return false;
			}
		}

		// 사각형 탐색
		int nx = x / 3 * 3;
		int ny = y / 3 * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[nx + i][ny + j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}
