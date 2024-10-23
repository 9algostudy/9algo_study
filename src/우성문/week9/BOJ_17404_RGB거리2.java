package 우성문.week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_17404_RGB거리2 {
	static int n,min = Integer.MAX_VALUE;
	static int[][] houses,dp;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input/Baek_17404.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		houses = new int[n+2][3];
		String[] a;
		for(int i = 1;i<=n;i++) {
			a= br.readLine().split(" ");
			houses[i][0] = Integer.parseInt(a[0]);
			houses[i][1] = Integer.parseInt(a[1]);
			houses[i][2] = Integer.parseInt(a[2]);
		}
		for(int idx = 0;idx<3;idx++) {
			dp = new int[n+2][3];
			for(int i = 0;i<3;i++) {
				if(i == idx) {
					dp[1][i] = houses[1][i];
				}else {
					dp[1][i] = 1001;
				}
			}
			for(int i = 2;i<n;i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+houses[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+houses[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+houses[i][2];
			}
			for(int i = 0;i<3;i++) {
				if(i != idx) {
					dp[n][i] = Math.min(dp[n-1][(i+1)%3], dp[n-1][(i+2)%3])+houses[n][i]; 
				}
			}
			min = Math.min(min, Math.min(dp[n][(idx+1)%3], dp[n][(idx+2)%3]));
		}
		System.out.println(min);
	}
}
