package 우성문.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n,k;
	static int[][] items;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/input/BOJ_12865_평범한배낭.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		items = new int[n][2];
		dp = new int[k+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());// 무게
			items[i][1] = Integer.parseInt(st.nextToken());// 가치
		}

		for(int i = 0; i < n; i++) {
			for(int j = k; j >= items[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j-items[i][0]]+items[i][1]);
			}
		}

		System.out.println(dp[k]);
	}
}