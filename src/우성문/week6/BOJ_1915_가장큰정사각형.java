package 우성문.week6;

import java.io.*;

public class BOJ_1915_가장큰정사각형{
	static int n,m;
	static int[][] dp;
			
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week6/BOJ_1915_가장큰정사각형.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		dp = new int[n+2][m+2];
		
		for(int i = 1;i<=n;i++) {
			String str = br.readLine().trim();
			for(int j = 1;j<=m;j++) {
				dp[i][j] = str.charAt(j-1) - '0'; 
			}
		}
		for(int i = n;i>0;i--) {
			for(int j = m;j>0;j--) {
				if(dp[i][j] == 0) continue;
				int min = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
				 dp[i][j] += min;
			}
		}
		
		int max = 0;
		for(int i = 1;i<=n;i++) for(int j = 1;j<=m;j++) max = Math.max(max, dp[i][j]*dp[i][j]);
		System.out.println(max);
	}
}
