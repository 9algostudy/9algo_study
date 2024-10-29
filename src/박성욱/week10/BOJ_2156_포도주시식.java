package 박성욱.week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n>1) {
		int arr [] = new int [n+1];
		for(int i = 0;i<n;i++) {
			arr[i+1] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[10001];
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		dp[2] = arr[1]+ arr[2];
		
		for(int i = 3; i<n+1;i++) {
			dp[i] = Math.max(Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-2]+arr[i]),dp[i-1]);
		}
		
		System.out.println(dp[n]);
		
		}
		else
			System.out.println(br.readLine());
	}

}
