package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class BOJ_13398_연속합2{
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		String[] s = br.readLine().split(" ");
//		int[] nums = new int[s.length];
//		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(s[i]);
//		
//		int[] dp1 = new int[N];
//		int[] dp2 = new int[N];
//		
//		dp1[0] = nums[0];
//		int max = dp1[0];
//
//		for (int i = 1; i < N; i++) {
//			dp1[i] = Math.max(dp1[i-1] + nums[i], nums[i]);
//			dp2[i] = Math.max(dp1[i-1], dp2[i-1]+nums[i]);
//			max = Math.max(Math.max(max, dp1[i]), dp2[i]);
//		}
//		
//		System.out.println(max);
//	}
//}

public class BOJ_13398_연속합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] nums = new int[s.length];
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(s[i]);
		
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		
		dp1[0] = nums[0];
		dp2[N-1] = nums[N-1];
		int max = dp1[0];

		for (int i = 1; i < N; i++) {
			dp1[i] = nums[i];
			if (dp1[i-1] > 0) dp1[i] += dp1[i-1];
			max = Math.max(max, dp1[i]);
			dp2[N-i-1] = nums[N-i-1];
			if (dp2[N-i] > 0) dp2[N-i-1] += dp2[N-i];
		}
		
		for (int i = 2; i < N; i++) {
			max = Math.max(max, dp1[i-2]+dp2[i]);
		}
		
		System.out.println(max);
	}
}