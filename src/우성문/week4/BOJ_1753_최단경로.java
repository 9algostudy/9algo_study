package 우성문.week4;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
	static ArrayList<int[]>[] list;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		int v = Integer.parseInt(line[0]);
		int e = Integer.parseInt(line[1]);
		int start = Integer.parseInt(br.readLine().trim());
		
		list = new ArrayList[v + 1];
		answer = new int[v + 1];
		visited = new boolean[v + 1];
		
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
			answer[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < e; i++) {
			line = br.readLine().trim().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			list[x].add(new int[] {y, w});
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		queue.add(new int[] {start, 0});
		answer[start] = 0;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currNode = current[0];
			int currDist = current[1];
			
			if (visited[currNode]) continue;  
			visited[currNode] = true;
			
			for (int[] next : list[currNode]) {
				int nextNode = next[0];
				int weight = next[1];
				if (answer[nextNode] > currDist + weight) {
					answer[nextNode] = currDist + weight;
					queue.add(new int[] {nextNode, answer[nextNode]});
				}
			}
		}
		
		for (int i = 1; i <= v; i++) {
			System.out.println(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
		}
	}
}
