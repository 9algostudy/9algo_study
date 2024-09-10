package 윤다은.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1916_최소비용구하기 {
	static class edge implements Comparable<edge>{
		int to;
		int w;
		
		public edge(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(edge o) {
			return this.w-o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<edge>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		String[] s;
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			list[Integer.parseInt(s[0])].add(new edge(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
		
		s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<edge> queue = new PriorityQueue<>();
		dist[start] = 0;
		
		queue.offer(new edge(start, 0));
		while (!queue.isEmpty()) {
			edge e = queue.poll();
			if (e.to == end) break;
			
			int len = list[e.to].size();
			for (int i = 0; i < len; i++) {
				edge tmp = list[e.to].get(i);
				if (dist[e.to] + tmp.w < dist[tmp.to]) {
					dist[tmp.to] = dist[e.to] + tmp.w;
					queue.offer(new edge(tmp.to, dist[tmp.to]));
				}
			}
		}
		
		System.out.println(dist[end]);
	}
}
