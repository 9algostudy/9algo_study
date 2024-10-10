package 박성욱.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9465_스티커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int arr [][] = new int[2][100001];
			String str [] = br.readLine().trim().split(" ");
			for(int i = 0; i<n;i++) {
				arr[0][i] = Integer.parseInt(str[i]);
			}
			String str1[] = br.readLine().trim().split(" ");
			for(int i = 0 ;i<n;i++) {
				arr[1][i] = Integer.parseInt(str1[i]);
			}
			
			int dp [][] = new int[2][100001];
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			
			for(int i = 2 ; i<n;i++) {
				dp[0][i] = Math.max(dp[1][i-2] + arr[0][i], dp[1][i-1]+arr[0][i]);
				dp[1][i] = Math.max(dp[0][i-2] + arr[1][i], dp[0][i-1]+arr[1][i]);
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
		
	}
}

