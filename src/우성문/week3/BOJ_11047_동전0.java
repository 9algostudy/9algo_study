package 우성문.week3;

import java.io.*;

public class BOJ_11047_동전0 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int idx = 0;
		int[] coins = new int[n];
		for(int i = 0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine().trim());
			if(coins[i]<=k) {
				idx = i;
			}
		}
		int cnt = 0;
		for(int i = idx;i>=0;i--) {
			cnt += k/coins[i];
			k -= (coins[i])*(k/coins[i]);
		}
		
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
