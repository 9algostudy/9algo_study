package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder(1000);
	static boolean[] visited;
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int v = Integer.parseInt(line[2]);

		for (int i = 0; i < m; i++) {
			line = br.readLine().trim().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);
			if (!graph.containsKey(start)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(end);
				graph.put(start, list);
			} else {
				ArrayList<Integer> list = graph.get(start);
				list.add(end);
				graph.put(start, list);
			}
			if (!graph.containsKey(end)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(start);
				graph.put(end, list);
			} else {
				ArrayList<Integer> list = graph.get(end);
				list.add(start);
				graph.put(end, list);
			}
		}
		for(ArrayList<Integer> list : graph.values()) {
			Collections.sort(list);
		}
		
		// DFS
		visited = new boolean[n + 1];
		dFS(v);
		sb.append("\n");


		// BFS
		visited = new boolean[n + 1];
		bFS(v);
		sb.append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	static void dFS(int visit) {
		if (visited[visit]) {
			return;
		}
		visited[visit] = true;
		sb.append(visit).append(" ");
		ArrayList<Integer> list = graph.get(visit);
		if (list != null) {
			for (int next : list) {
				if (!visited[next]) {
					dFS(next);
				}
			}
		}
	}

	static void bFS(int visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(visit);
		visited[visit] = true;
		while (!queue.isEmpty()) {
			int next = queue.poll();
			sb.append(next).append(" ");
			ArrayList<Integer> list = graph.get(next);
			if (list != null) {
				for (int room : list) {
					if (!visited[room]) {
						visited[room] = true;
						queue.add(room);
					}
				}
			}
		}
	}
}
