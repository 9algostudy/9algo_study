package 윤다은.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer>[]	list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (st.nextToken().equals("1")) {
					list[i].add(j);
				}
			}
		}
		
		List<Integer> path = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			path.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(path.get(0));
		int[] visited = new int[N+1];
		visited[path.get(0)] = 1;
		
		while (!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 0; i < list[n].size(); i++) {
				int tmp = list[n].get(i);
				if (visited[tmp] == 1) continue;
				visited[tmp] = 1;
				queue.offer(tmp);
			}
		}
		
		for (int i = 0; i < M; i++) {
			if (visited[path.get(i)] == 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
