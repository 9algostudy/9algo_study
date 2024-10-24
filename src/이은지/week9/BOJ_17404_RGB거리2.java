package 이은지.week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {

	static int N, min;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][3];
		dp = new int[N][3];


		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		min = 987654321;

		//처음
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		for (int i = 0; i < 3; i++) { //처음 집 인덱스

			for (int j = 0 ; j < 3; j++) { // 마지막 집 인덱스

				if (i == j) continue; // 처음이랑 마지막 집이 같은색일수 없음

				//두번째 집
				for (int k = 0; k < 3; k++) {
					if (k == i) {
						dp[1][k] = 987654321;
						continue;
					}

					dp[1][k] = arr[1][k] + dp[0][i];
				}


				for (int k = 2; k < N - 1; k++) {

					dp[k][0] = arr[k][0] + Math.min(dp[k - 1][1], dp[k - 1][2]);
					dp[k][1] = arr[k][1] + Math.min(dp[k - 1][0], dp[k - 1][2]);
					dp[k][2] = arr[k][2] + Math.min(dp[k - 1][0], dp[k - 1][1]);

				}

				// 마지막 집
				for (int k = 0; k < 3; k++) {
					if (k == j) {
						dp[N - 1][k] = 987654321;
						continue;
					}

					dp[N - 1][k] = arr[N - 1][j] + dp[N - 2][k];
				}

				min = Math.min(min, Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
			}
		}


		System.out.println(min);

	}

}

