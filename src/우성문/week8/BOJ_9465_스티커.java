package 우성문.week8;

import java.io.*;

public class BOJ_9465_스티커 {
	static int n;
	static int[][] sticker;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week8/BOJ_9465_스티커.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine());
			sticker = new int[2][n+1];
			dp = new int[2][n+1];
			String[] a = br.readLine().split(" ");
			String[] b = br.readLine().split(" ");
			for(int i = 0;i<n;i++) {
				sticker[0][i+1] = Integer.parseInt(a[i]);
				sticker[1][i+1] = Integer.parseInt(b[i]);
			}
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			for(int i = 2;i<=n;i++) {
				dp[0][i] = Math.max(dp[1][i-1]+sticker[0][i], Math.max(dp[0][i-2], dp[1][i-2])+sticker[0][i]);
				dp[1][i] = Math.max(dp[0][i-1]+sticker[1][i], Math.max(dp[0][i-2], dp[1][i-2])+sticker[1][i]);
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
