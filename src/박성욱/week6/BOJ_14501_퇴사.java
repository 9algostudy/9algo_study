package 박성욱.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14501_퇴사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n + 1];
		int t[] = new int[n];
		int p[] = new int[n];
		for (int i = 0; i < n; i++) {
			String tp[] = br.readLine().trim().split(" ");
			t[i] = Integer.parseInt(tp[0]);
			p[i] = Integer.parseInt(tp[1]);
		}
		for (int i = 0; i < n; i++) {
			//날짜가 n을 넘어갈경우 체크
			int day = i + t[i];
			if (day <= n) {
				//지금 이익 vs 기존 이익 + 얻을 이익
				dp[day] = Math.max(dp[day], dp[i] + p[i]);
			}
			//지금까지의 최대 이익 계산
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
	}
}