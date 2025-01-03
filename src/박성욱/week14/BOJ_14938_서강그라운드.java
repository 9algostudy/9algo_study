package 박성욱.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end;
	int price;

	Node(int end, int price) {
		this.end = end;
		this.price = price;
	}

	@Override
	public int compareTo(Node o) {
		return price - o.price;
	}
}

public class BOJ_14938_서강그라운드 {
	static int n, m, k;
	static int[] items;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		items = new int[n + 1];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end, weight));
			graph.get(end).add(new Node(start, weight));
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			res = Math.max(res, dijk(i));
		}

		System.out.println(res);
	}

	private static int dijk(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (visited[cur]) continue;
			visited[cur] = true;

			for (Node next : graph.get(cur)) {
				if (!visited[next.end] && dist[next.end] > dist[cur] + next.price) {
					dist[next.end] = dist[cur] + next.price;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				cnt += items[i];
			}
		}

		return cnt;
	}
}
