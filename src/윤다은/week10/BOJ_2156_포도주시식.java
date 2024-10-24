package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		
		dp1[0] = Integer.parseInt(br.readLine());
		dp1[1] = Integer.parseInt(br.readLine());
		dp2[1] = dp1[0];
		int a;
		for (int i = 2; i < N; i++) {
			a = Integer.parseInt(br.readLine());
			dp1[i] = Math.max(dp2[i-1], dp2[i-2]) + a;
			dp2[i] = dp1[i-1];
		}
		
		System.out.println(Math.max(dp1[N-1], dp2[N-1]));
	}
}
