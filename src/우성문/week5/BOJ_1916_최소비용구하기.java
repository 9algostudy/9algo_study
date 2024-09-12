package 우성문.week5;

import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용구하기 {
	static int n, m, start, end;
	static int[][] map;
	static boolean[][] isFirst;
	static boolean[] visited;
	static int[] minDistance;

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
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_1916_최소비용구하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;

		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		map = new int[n + 1][n + 1];
		isFirst = new boolean[n+1][n+1];

		for (int i = 0; i < m; i++) {
			line = br.readLine().trim().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			int weight = Integer.parseInt(line[2]);
			if (isFirst[from][to]) {
				map[from][to] = Math.min(map[from][to], weight);
			} else {
				map[from][to] = weight;
				isFirst[from][to] = true;
			}
		}
		line = br.readLine().trim().split(" ");
		start = Integer.parseInt(line[0]);
		end = Integer.parseInt(line[1]);

		visited = new boolean[n + 1];
		minDistance = new int[n + 1];
		Arrays.fill(minDistance, Integer.MAX_VALUE);

		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start, start, 0));
		minDistance[start] = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (visited[e.to]) continue;
			visited[e.to] = true;
			// 도착 노드가 목표지점이면 break
			if (e.to == end)
				break;
			for (int i = 1; i < n + 1; i++) {
				if (!visited[i] && isFirst[e.to][i] && (map[e.to][i] + minDistance[e.to] < minDistance[i])) {
					minDistance[i] = map[e.to][i] + minDistance[e.to];
					queue.offer(new Edge(e.to, i, minDistance[i]));
				}
			}
		}
		System.out.println(visited[end]?minDistance[end]:0);
	}
}
