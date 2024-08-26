package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1753_최단경로 {
	static class edge {
		int u;
		int v;
		int w;
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
			edge tmp = new edge();
			tmp.u = Integer.parseInt(s[0]);
			tmp.v = Integer.parseInt(s[1]);
			tmp.w = Integer.parseInt(s[2]);
			list[tmp.u].add(tmp);
		}
		
		int[] min = new int[V+1];
		
		Queue<edge> find = new LinkedList<>();
		for (int i = 0; i < list[start].size(); i++) {
			find.offer(list[start].get(i));
		}
		
		while (!find.isEmpty()) {
			edge tmp = find.poll();
			if (tmp.v == start) continue;
			if (min[tmp.v] == 0 || min[tmp.u] + tmp.w < min[tmp.v]) {
				min[tmp.v] = min[tmp.u] + tmp.w;
				for (int i = 0; i < list[tmp.v].size(); i++) {
					find.offer(list[tmp.v].get(i));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (i == start) System.out.println(0);
			else System.out.println(min[i]==0 ? "INF" : min[i]);
		}
	}
}
