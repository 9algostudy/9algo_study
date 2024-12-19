package 윤다은.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1504_특정한최단경로 {
	static int[][] graph;
	static int N;

	static class Node implements Comparable<Node>{
		int cur;
		int totalDist;

		public Node(int cur, int totalDist) {
			this.cur = cur;
			this.totalDist = totalDist;
		}

		@Override
		public int compareTo(Node o) {
			return this.totalDist-o.totalDist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);

		graph = new int[N+1][N+1];

		int a, b, c;
		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			c = Integer.parseInt(s[2]);

			graph[a][b] = c;
			graph[b][a] = c;
		}

		s = br.readLine().split(" ");
		int v1 = Integer.parseInt(s[0]);
		int v2 = Integer.parseInt(s[1]);

		long res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		long res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		long res = Math.min(res1, res2);
		System.out.println(res >= Integer.MAX_VALUE ? -1 : res);
	}

	static long dijkstra(int start, int end) {
		int[] visited = new int[N+1];
		Arrays.fill(visited, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		visited[start] = 0;

		int min = Integer.MAX_VALUE;

		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int cur = tmp.cur;

			if (tmp.totalDist >= min) continue;

			if (cur == end) {
				min = Math.min(min, tmp.totalDist);
				break;
			}

			for (int i = 1; i < N+1; i++) {
				if (graph[cur][i] > 0 && visited[i] > tmp.totalDist + graph[cur][i]) {
					visited[i] = tmp.totalDist + graph[cur][i];
					pq.offer(new Node(i, visited[i]));
				}
			}
		}

		return min;
	}
}
