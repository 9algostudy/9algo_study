package 이은지.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기{

	static int N;
	static int[][] maxDp, minDp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		maxDp = new int[N][3];
		minDp = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[i][0] = minDp[i][0] = a;
				maxDp[i][1] = minDp[i][1] = b;
				maxDp[i][2] = minDp[i][2] = c;
			} else {
				maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + a;
				maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + b;
				maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + c;

				minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + a;
				minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + b;
				minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + c;
			}
		}

		int max = Math.max(Math.max(maxDp[N - 1][0], maxDp[N - 1][1]), maxDp[N - 1][2]);
		int min = Math.min(Math.min(minDp[N - 1][0], minDp[N - 1][1]), minDp[N - 1][2]);

		System.out.println(max + " " + min);
	}

}
