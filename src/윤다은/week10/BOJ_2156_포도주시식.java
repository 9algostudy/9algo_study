package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		
		dp[1] = arr[1];
		
		if (N == 1) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-1]));
		}
		
		System.out.println(dp[N]);
	}
}
