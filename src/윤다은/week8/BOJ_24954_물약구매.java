package 윤다은.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_24954_물약구매 {
	static int N, min = Integer.MAX_VALUE;
	static int[] prices;
	static List<int[]>[] discount;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new int[N+1];
		prices = new int[N+1];
		String[] s = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			prices[i] = Integer.parseInt(s[i-1]);
		}
		
		discount = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			discount[i] = new ArrayList<>();
			int p = Integer.parseInt(br.readLine());
			for (int j = 0; j < p; j++) {
				s = br.readLine().split(" ");
				discount[i].add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
			}
		}
		
		for (int i = 1; i <= N; i++) {
			visited[i] = 1;
			dfs(i, 1, prices[i]);
			visited[i] = 0;
		}
		
		System.out.println(min);
	}
	
	static void dfs(int n, int depth, int sum) {
		if (sum >= min) return;
		if (depth == N) {
			min = sum;
			return;
		}
		
		for (int[] d : discount[n]) {
			prices[d[0]] -= d[1];
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] == 1) continue;
			visited[i] = 1;
			int a = prices[i] > 0 ? prices[i] : 1;
			dfs(i, depth+1, sum + a);
			visited[i] = 0;
		}
		
		for (int[] d : discount[n]) {
			prices[d[0]] += d[1];
		}
	}
}
