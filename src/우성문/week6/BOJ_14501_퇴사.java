package 우성문.week6;

import java.io.*;

public class BOJ_14501_퇴사{
	static int n;
	static int[][] arr;
	static int[] dp;
			
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week6/BOJ_14501_퇴사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		arr = new int[n+1][2];
		String[] line;
		for(int i = 1;i<=n;i++) {
			line = br.readLine().trim().split(" ");
			arr[i][0] = Integer.parseInt(line[0]);
			arr[i][1] = Integer.parseInt(line[1]);
		}
		if(n+arr[n][0]==n+1) dp[n] = arr[n][1];
		for(int i = n-1;i>0;i--) {
			int finish = i+arr[i][0];
			if(finish==n+1) {
				dp[i] = Math.max(dp[i+1], arr[i][1]);
			}else if(finish>n+1) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(dp[i+1], dp[finish]+arr[i][1]);
			}
		}
		System.out.println(dp[1]);
	}
}
