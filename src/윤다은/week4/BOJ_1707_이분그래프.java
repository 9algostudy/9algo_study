package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1707_이분그래프 {
	static int[] visited;
	static int[] team;
	static int[] twoteams = {10, 20};
	static List<Integer>[] list;
	static String res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			
			list = new ArrayList[V+1];
			
			for (int i = 1; i < V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			team = new int[V+1];
			
			int v1, v2;
			
			for (int i = 0; i < E; i++) {
				s = br.readLine().split(" ");
				v1 = Integer.parseInt(s[0]);
				v2 = Integer.parseInt(s[1]);
				
				list[v1].add(v2);
				list[v2].add(v1);
			}
			
			
			res = "YES";
			//그래프가 전부 연결되어있지 않은 경우를 위해 for문 돌리기
			for (int i = 1; i <= V; i++) {
				if (team[i] == 0) {
					team[i] = twoteams[0];
					dfs(i, 1);
				}
				if (res.equals("NO")) break;
			}
			
			System.out.println(res);
		}
		
	}
	
	static void dfs(int cur, int t) {
		if (res.equals("NO")) return;
		
		for (int i = 0; i < list[cur].size(); i++) {
			int n = list[cur].get(i);
			if (team[cur] == team[n]) {
				res = "NO";
				return;
			}
			if (team[n] == 0) {
				team[n] = twoteams[t];
				dfs(n, (t+1)%2);
			}
		}
	}
}
