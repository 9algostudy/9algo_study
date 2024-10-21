package 윤다은.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1197_최소스패닝트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);

		List<int[]>[] edges = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}
		
		int a, b, c;
		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			c = Integer.parseInt(s[2]);
			edges[a].add(new int[] {b, c});
			edges[b].add(new int[] {a, c});
		}
		
		long sum = 0;
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		pq.offer(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (visited[tmp[0]]) continue;
			visited[tmp[0]] = true;
			sum += tmp[1];
			
			for (int[] t : edges[tmp[0]]) {
				if (visited[t[0]]) continue;
				pq.offer(new int[] {t[0], t[1]});
			}
		}
		
		System.out.println(sum);
	}

}
