package 윤다은.week4;

import java.io.*;
import java.util.*;

import 윤다은.week4.BOJ_1753_최단경로.edge;

public class BOJ_1753_최단경로 {
	static final int INF = Integer.MAX_VALUE;
	
	//우선순위큐 사용
	static class edge implements Comparable<edge>{
		int v;
		int w;
		
		edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(edge n) {
			return this.w - n.w;
		};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<edge>[] list = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			edge tmp = new edge(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			list[Integer.parseInt(s[0])].add(tmp);
		}
		
		int[] min = new int[V+1];
		Arrays.fill(min, INF);
		min[start] = 0;
		
		PriorityQueue<edge> find = new PriorityQueue<edge>();
		int len;
		edge t = new edge(start, 0);
		find.offer(t);
		
		while (!find.isEmpty()) {
			edge tmp = find.poll();
			len = list[tmp.v].size();
			
			for (int i = 0; i < len; i++) {
				edge next = list[tmp.v].get(i);
				
				if (min[next.v]>min[tmp.v]+next.w) {
					min[next.v] = min[tmp.v]+next.w;
					//이거 그냥 find.offer(next) 하면 시간초과남 당연하지 바보야 안틀린게 더 이상하다
					find.offer(new edge(next.v, min[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(min[i]==INF ? "INF" : min[i]);
		}
	}

	// 메모리 초과
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] s = br.readLine().split(" ");
//		int V = Integer.parseInt(s[0]);
//		int E = Integer.parseInt(s[1]);
//		
//		int start = Integer.parseInt(br.readLine());
//		
//		int[][] graph = new int[V+1][V+1];
//		
//		for (int i = 0; i < E; i++) {
//			s = br.readLine().split(" ");
//			graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = Integer.parseInt(s[2]);
//		}
//		
//		Queue<Integer> queue = new LinkedList<>();
//		int[] min = new int[V+1];
//		
//		for (int i = 1; i <= V; i++) {
//			if (graph[start][i] != 0) {
//				min[i] = graph[start][i];
//				queue.offer(i);
//			}
//		}
//		while (!queue.isEmpty()) {
//			Integer tmp = queue.poll();
//			for (int i = 1; i <= V; i++) {
//				if (i == start) continue;
//				if (graph[tmp][i] != 0) {
//					if (min[i] == 0 || graph[tmp][i] + min[tmp] < min[i]) {
//						min[i] = graph[tmp][i] + min[tmp];
//						queue.offer(i);
//					}
//				}
//			}
//		}
//		
//		for (int i = 1; i <= V; i++) {
//			if (i == start) System.out.println(0);
//			else System.out.println(min[i]==0?"INF":min[i]);
//		}
//	}
	
	
	//시간초과
//	static class edge {
//		int u;
//		int v;
//		int w;
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] s = br.readLine().split(" ");
//		int V = Integer.parseInt(s[0]);
//		int E = Integer.parseInt(s[1]);
//		
//		int start = Integer.parseInt(br.readLine());
//		
//		ArrayList<edge>[] list = new ArrayList[V+1];
//		
//		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
//		
//		for (int i = 0; i < E; i++) {
//			s = br.readLine().split(" ");
//			edge tmp = new edge();
//			tmp.u = Integer.parseInt(s[0]);
//			tmp.v = Integer.parseInt(s[1]);
//			tmp.w = Integer.parseInt(s[2]);
//			list[tmp.u].add(tmp);
//		}
//		
//		int[] min = new int[V+1];
//		
//		Queue<edge> find = new LinkedList<>();
//		for (int i = 0; i < list[start].size(); i++) {
//			find.offer(list[start].get(i));
//		}
//		
//		while (!find.isEmpty()) {
//			edge tmp = find.poll();
//			if (tmp.v == start) continue;
//			if (min[tmp.v] == 0 || min[tmp.u] + tmp.w < min[tmp.v]) {
//				min[tmp.v] = min[tmp.u] + tmp.w;
//				for (int i = 0; i < list[tmp.v].size(); i++) {
//					find.offer(list[tmp.v].get(i));
//				}
//			}
//		}
//		
//		for (int i = 1; i <= V; i++) {
//			if (i == start) System.out.println(0);
//			else System.out.println(min[i]==0 ? "INF" : min[i]);
//		}
//	}
}
