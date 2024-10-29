package 박성욱.week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11052_카드구매하기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str [] = br.readLine().trim().split(" ");
		int arr [] = new int[n+1];
		for(int i = 0; i<str.length;i++) {
			arr[i+1] = Integer.parseInt(str[i]);
		}
		
		int dp [] = new int[10001];
		dp[0] = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0 ; j<arr.length;j++) {
				dp[i+j] = Math.max(dp[i]+arr[j], dp[i+j]);
			}
		}
		
		
		System.out.println(dp[n]);
		
		
	}

}
