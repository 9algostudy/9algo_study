package 우성문.week6;

import java.io.*;
import java.util.*;

public class BOJ_13398_연속합2{
	static int n,max=Integer.MIN_VALUE;
	static int[] nums;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week6/BOJ_13398_연속합2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n+1];
		dp = new int[n+1][2];
		String[] line = br.readLine().trim().split(" ");
		for(int i = 0;i<n;i++) nums[i+1] = Integer.parseInt(line[i]);
		
		dp[1][0] = nums[1];
		dp[1][1] = nums[1];
		for(int i = 2 ;i<=n;i++) {
			if(nums[i]>=0) {
				dp[i][0] = Math.max(dp[i-1][0]+nums[i], nums[i]);
				dp[i][1] = dp[i-1][1]+nums[i];
			}else {
				if(dp[i-1][0]+nums[i]>=0) {
					dp[i][0] = dp[i-1][0]+nums[i];
				}else {
					dp[i][0] = nums[i];
				}
				dp[i][1] = Math.max(dp[i-1][1]+nums[i], dp[i-1][0]);
			}
		}
		int answer = Integer.MIN_VALUE;
		for(int i = 1;i<=n;i++) answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
		System.out.println(answer);
	}
}
