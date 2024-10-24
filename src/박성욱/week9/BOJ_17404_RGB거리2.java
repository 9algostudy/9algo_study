package 박성욱.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17404_RGB거리2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [][] = new int [n+1][3];
		int dp[] []= new int[10001] [3];
		for(int i = 0;i<n;i++) {
			String str [] = br.readLine().trim().split(" ");
			arr[i+1][0] = Integer.parseInt(str[0]);
			arr[i+1][1] = Integer.parseInt(str[1]);
			arr[i+1][2] = Integer.parseInt(str[2]);
		}
		
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		
		for(int i = 2;i<n+1;i++) {
			dp[i][0] = Math.min( dp[i-1][1],dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min( dp[i-1][0],dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min( dp[i-1][0],dp[i-1][1]) + arr[i][2];
		}
		
		int res = Math.min( Math.min(dp[n][0], dp[n][1]),dp[n][2] );
		
		System.out.println(res);

		
		
	}

}
