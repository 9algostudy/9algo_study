package 윤다은.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1647_도시분할계획 {

	static int[] parent;

	static class Road {
		int a;
		int b;
		int cost;

		public Road(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		PriorityQueue<Road> pq = new PriorityQueue<Road>(new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				return o1.cost-o2.cost;
			}
		});

		int a, b, cost;
		for (int i = 0; i < M; i++)  {
			s = br.readLine().split(" ");

			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			cost = Integer.parseInt(s[2]);

			Road r = new Road(a, b, cost);
			pq.add(r);
		}

		int totalCost = 0;
		N -= 2;
		while (N > 0) {
			Road tmp = pq.poll();

			if (findParent(tmp.a) != findParent(tmp.b)) {
				union(tmp.a, tmp.b);
				totalCost += tmp.cost;
				N--;
			}
		}

		System.out.println(totalCost);
	}

	static int findParent(int a) {
		if (parent[a] == a) return a;
		return parent[a] = findParent(parent[a]);
	}

	static void union(int a, int b) {
		parent[parent[b]] = parent[a];
	}
}
