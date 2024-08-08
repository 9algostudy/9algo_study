package 윤다은.week2;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {
	static ArrayList<Integer>[] con;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int u, v;
		
		con = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			con[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			con[u].add(v);
			con[v].add(u);
		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			if (dfs(0, i)) {
				System.out.println(1);
				return;
			}
			visited[i] = false;
		}
		System.out.println(0);
	}
	
	static boolean dfs(int depth, int from) {
		if (depth == 4) {
			return true;
		}
		
		ArrayList<Integer> tmp = con[from];
		for (Integer i : tmp) {
			if (visited[i]) continue;
			visited[i] = true;
			if (dfs(depth+1, i)) return true;
			visited[i] = false;
		}
		
		return false;
	}
}
