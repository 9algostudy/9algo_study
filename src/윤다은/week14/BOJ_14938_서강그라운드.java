package 윤다은.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
	static int n, m, r;
	static int[] list;
	static int[][] graph;
	static int max;

	static class Road implements Comparable<Road>{
		int end;
		int distance;

		public Road(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Road o) {
			return o.distance - this.distance;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		list = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		graph = new int[n+1][n+1];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = c;
			graph[b][a] = c;
		}

		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}

		System.out.println(max);
	}

	static void dijkstra(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, 20);
		dist[start] = 0;

		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		pq.offer(new Road(start, 0));

		while (!pq.isEmpty()) {
			Road tmp = pq.poll();

			for (int i = 1; i <= n; i++) {
				int nextDistance = graph[tmp.end][i] + dist[tmp.end];
				if (graph[tmp.end][i] > 0 && dist[i] > nextDistance) {
					dist[i] = nextDistance;
					pq.offer(new Road(i, nextDistance));
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) sum += list[i];
		}
		max = Math.max(sum, max);
	}
}
