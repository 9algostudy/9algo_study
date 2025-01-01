package 이은지.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1890_점프 {
	static int N;
	static int[][] map;
	static long[][] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (count[i][j] == 0 || map[i][j] == 0) {
					continue;
				}

				int num = map[i][j];

				if (i + num < N) {
					count[i + num][j] += count[i][j];
				}

				if (j + num < N) {
					count[i][j + num] += count[i][j];
				}
			}
		}

		System.out.println(count[N - 1][N - 1]);
	}
}
