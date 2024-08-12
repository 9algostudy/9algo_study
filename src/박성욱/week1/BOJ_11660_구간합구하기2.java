package 박성욱.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11660_구간합구하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmarr = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmarr[0]);
		int m = Integer.parseInt(nmarr[1]);

		int[][] arr = new int[n + 1][n + 1];

		for (int i = 1; i < n+1; i++) {
			String[] inputarr = br.readLine().trim().split(" ");
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(inputarr[j-1]);
			}
		}
		int[][] sumArr = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			String xyarr[] = br.readLine().trim().split(" ");
			int x1 = Integer.parseInt(xyarr[0]);
			int y1 = Integer.parseInt(xyarr[1]);
			int x2 = Integer.parseInt(xyarr[2]);
			int y2 = Integer.parseInt(xyarr[3]);

			int res = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];

			System.out.println(res);
		}

	}

}
