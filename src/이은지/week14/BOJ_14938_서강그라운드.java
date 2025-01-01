package 이은지.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {

	static int N, M, R, max;
	static int[] items, dist;
	static ArrayList<Node>[] list;

	static class Node implements Comparable<Node> {
		int posNum, len;

		public Node(int posNum, int lenth) {
			this.posNum = posNum;
			this.len = lenth;
		}

		@Override
		public int compareTo(Node node) {
			return len - node.len;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		items = new int[N + 1];
		dist = new int[N + 1];
		list = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, l));
			list[b].add(new Node(a, l));
		}

		for (int i = 0; i < N; i++) {
			dijkstra(i);
		}

		System.out.println(max);

	}

	private static void dijkstra(int idx) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N + 1];

		pq.offer(new Node(idx, 0));
		dist[idx] = 0;

		while (!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int now = nowNode.posNum;

			if (!visited[now]) {
				visited[now] = true;

				for (Node node : list[now]) {
					if (visited[node.posNum] || dist[node.posNum] <= dist[now] + node.len) {
						continue;
					}

					dist[node.posNum] = dist[now] + node.len;
					pq.offer(new Node(node.posNum, dist[node.posNum]));
				}
			}
		}

		int result = 0;

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= M) {
				result += items[i];
			}
		}

		max = Math.max(result, max);

	}

}
