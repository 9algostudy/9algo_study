package 윤다은.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];
			
			String[] s;
			for (int i = 0; i < 2; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int[][] dp = new int[N][3];
			dp[0][0] = 0;
			dp[0][1] = sticker[0][0];
			dp[0][2] = sticker[1][0];
			
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
				dp[i][1] = sticker[0][i] + Math.max(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = sticker[1][i] + Math.max(dp[i-1][0], dp[i-1][1]);
			}
			
			System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
		}
	}
}
