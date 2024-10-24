package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11052_카드구매하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] price = new int[N+1];
		String[] s = br.readLine().split(" ");
		
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(s[i-1]);
		}
		
		int[] dp = new int[N+1];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i+j <= N) dp[i+j] = Math.max(dp[i]+price[j], dp[i+j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
