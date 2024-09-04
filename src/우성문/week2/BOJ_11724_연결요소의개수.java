package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_11724_연결요소의개수 {
	static StringBuilder sb = new StringBuilder(1000);
	static boolean[] visited;
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(1000);

		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			line = br.readLine().trim().split(" ");
			int node1 = Integer.parseInt(line[0]);
			int node2 = Integer.parseInt(line[1]);
			if (!graph.containsKey(node1)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(node2);
				graph.put(node1, list);
			} else {
				ArrayList<Integer> list = graph.get(node1);
				list.add(node2);
				graph.put(node1, list);
			}
			if (!graph.containsKey(node2)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(node1);
				graph.put(node2, list);
			} else {
				ArrayList<Integer> list = graph.get(node2);
				list.add(node1);
				graph.put(node2, list);
			}
		}
		
		while(true) {
			int node = isVisitedAll();
			if(node==-1) {
				break;
			}
			dFS(node);
			cnt++;
		}
		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static int isVisitedAll() { 
		for(int i = 1;i<visited.length;i++) {
			if(!visited[i]) {
				return i;
			}
		}
		return -1;
	}
	
	static void dFS(int visit) {
		if (visited[visit]) {
			return;
		}
		visited[visit] = true;
		ArrayList<Integer> list = graph.get(visit);
		if (list != null) {
			for (int next : list) {
				if (!visited[next]) {
					dFS(next);
				}
			}
		}
	}
}
