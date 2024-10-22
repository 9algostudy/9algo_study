package 윤다은.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17404_RGB거리2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[3][3];
		int[][] tmp = new int[3][3];

		for (int i = 0; i < 3; i++) {
			Arrays.fill(RGB[i], 10000000);
		}

		String[] s;
		s = br.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			RGB[i][i] = Integer.parseInt(s[i]);
		}

		for (int i = 1; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				int t = Integer.parseInt(s[j]);
				for (int k = 0; k < 3; k++) {
					tmp[k][j] = t + Math.min(RGB[k][(j + 1) % 3], RGB[k][(j + 2) % 3]);
				}
			}
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					RGB[k][j] = tmp[k][j];
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			RGB[i][i] = Math.min(RGB[i][(i + 1) % 3], RGB[i][(i + 2) % 3]);
		}

		System.out.println(Math.min(RGB[0][0], Math.min(RGB[1][1], RGB[2][2])));
	}
}
