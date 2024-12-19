package 이은지.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {

	static int N, M;
	static int[] parent;
	static ArrayList<Node> road = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int a, b, w;

		public Node(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			road.add(new Node(a, b, w));
		}

		Collections.sort(road);
		int sum = 0;
		int max = -1;

		for (Node n : road) {
			if (find(n.a) == find(n.b)) {
				continue;
			}
			union(n.a, n.b);
			sum += n.w;
			max = Math.max(max, n.w);
		}

		System.out.println(sum - max);
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA <= rootB) {
			parent[rootB] = rootA;
		} else {
			parent[rootA] = rootB;
		}
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}
