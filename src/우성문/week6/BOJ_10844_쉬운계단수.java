package 우성문.week6;

import java.util.*;
import java.util. *;

public class BOJ_10844_쉬운계단수{
	static final int num =  1000000000;
	static int n;
	static long[][] dp = new long[101][10];
			
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		
		for(int i = 2;i<=100;i++) {
			for(int j = 0;j<10;j++) {
				dp[i][j] += (j>0?dp[i-1][j-1]:0)+(j<9?dp[i-1][j+1]:0);
				dp[i][j] %=num;
			}
		}
		
		long answer = 0;
		for(int j = 0; j < 10; j++) {
			answer = (answer+dp[n][j])%num;
		}
		System.out.println(answer);
	}
}
