package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2342_DDR{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int len = s.length;
		int[][][] dp = new int[len][5][5];
		
		for (int i = 0; i < 5; i++)
			Arrays.fill(dp[0][i], 1000000);
		int step = Integer.parseInt(s[0]);
		dp[0][0][step] = 2;
		dp[0][step][0] = 2;
		
		for (int i = 1; i < len-1; i++) {
			for (int j = 0; j < 5; j++)
				Arrays.fill(dp[i][j], 1000000);
			
			step = Integer.parseInt(s[i]);
			int n;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (j != step) {
						if (k == 0) n = 2;
						else if (k == step) n = 1;
						else if (Math.abs(k-step) == 2) n = 4;
						else n = 3;
						dp[i][j][step] = Math.min(dp[i][j][step], dp[i-1][j][k]+n);
					}
					if (k != step) {
						if (j == 0) n = 2;
						else if (j == step) n = 1;
						else if (Math.abs(j-step) == 2) n = 4;
						else n = 3;
						dp[i][step][k] = Math.min(dp[i][step][k], dp[i-1][j][k]+n);
					}
				}
			}
		}
		
		int res = 1000000;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				res = Math.min(res, dp[len-2][i][j]);
			}
		}
		
		System.out.println(res);
	}
}
