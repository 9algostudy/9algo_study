package 이은지.week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {

	static int V, E, result;
	static Node[] nodes;
	static int[] parent;

	static class Node {
		int a, b, w;

		public Node(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		result = 0;

		parent = new int[V + 1];
		nodes = new Node[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			nodes[i] = new Node(a, b, w);
		}

		//정렬
		Arrays.sort(nodes, (o1, o2) -> o1.w - o2.w);

		//Makeset
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			if (find(nodes[i].a) == find(nodes[i].b)) {
				continue;
			}
			union(nodes[i].a, nodes[i].b);
			result += nodes[i].w;
		}

		System.out.println(result);

	}

	private static void union(int a, int b) {
		a = parent[a];
		b = parent[b];
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
}

