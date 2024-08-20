package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	
	static int N;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int begin = Integer.parseInt(st.nextToken());
		
		int u, v;
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			graph[u][v] = 1;
			graph[v][u] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		sb.append(begin).append(" ");
		visited[begin] = true;
		dfs(begin);
		sb.append("\n");
		
		visited[begin] = false;
		queue.add(begin);
		int tmp;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			sb.append(tmp).append(" ");
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] || graph[tmp][i] == 0) continue;
				visited[i] = false;
				queue.add(i);
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int begin) {
		for (int i = 1; i <= N; i++) {
			if (visited[i] || graph[begin][i] == 0) continue;
			sb.append(i).append(" ");
			visited[i] = true;
			dfs(i);
		}
	}
}
