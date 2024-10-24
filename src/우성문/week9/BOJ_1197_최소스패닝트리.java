package 우성문.week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1197_최소스패닝트리 {
	static int v, e;
	static int[][] houses, dp;
	static Edge[] edges;
	static int[] parent;
	static int[] rank;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_1197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		v = Integer.parseInt(a[0]);
		e = Integer.parseInt(a[1]);
		edges = new Edge[e];
		parent = new int[v+1];
		rank = new int[v+1];
		for(int i = 1;i<=v;i++) parent[i] = i;

		for (int i = 0; i < e; i++) {
			a = br.readLine().split(" ");
			int from = Integer.parseInt(a[0]);
			int to = Integer.parseInt(a[1]);
			int weight = Integer.parseInt(a[2]);
			edges[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edges);
		
		int answer = 0;
		for(Edge e : edges) {
			if(find(e.from)==find(e.to)) continue;
			answer += e.weight;
			union(e.from,e.to);
		}
		System.out.println(answer);

	}
}
