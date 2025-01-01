package 이은지.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {

	static int N, E, V1, V2;

	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}

	static ArrayList<ArrayList<Node>> graph;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, w));
			graph.get(b).add(new Node(a, w));
		}

		st = new StringTokenizer(br.readLine());

		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());

		// 1. 1 -> V1 -> V2 -> N
		int result1 = 0;
		result1 += dijkstra(1, V1);
		result1 += dijkstra(V1, V2);
		result1 += dijkstra(V2, N);

		// 2. 1 -> V2 -> V1 -> N
		int result2 = 0;
		result2 += dijkstra(1, V2);
		result2 += dijkstra(V2, V1);
		result2 += dijkstra(V1, N);

		int answer;
		if (result1 >= INF && result2 >= INF) {
			answer = -1;
		} else {
			answer = Math.min(result1, result2);
		}

		System.out.println(answer);

	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			dist[i] = INF;
		}

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.v;

			if (visited[cur]) {
				continue;
			}
			visited[cur] = true;

			for (Node next : graph.get(cur)) {
				if (!visited[next.v] && dist[next.v] > dist[cur] + next.w) {
					dist[next.v] = dist[cur] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}

		return dist[end];
	}

}
