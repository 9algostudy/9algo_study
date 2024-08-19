package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cities = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int[] visited = new int[cities+1];
		
		Map<Integer, ArrayList<Integer>> m = new HashMap<>();
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i <roads; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			ArrayList<Integer> val;
			if (m.containsKey(k)) {
				val = m.get(k);
			}
			else {
				val = new ArrayList<>();
			}
			val.add(Integer.parseInt(st.nextToken()));
			m.put(k, val);
		}
		
		que.add(start);
		while (!que.isEmpty()) {
			int key = que.poll();
			if (visited[key] == distance) break;
			if (m.get(key) == null) continue;
			for (Integer a : m.get(key)) {
				if (visited[a] == 0) {
					visited[a] = visited[key] + 1;
					que.add(a); 
				}
			}
		}
		visited[start] = 0;
		
		for (int i = 1; i <= cities; i++) {
			if (visited[i] == distance) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.length() == 0 ? -1 : sb.toString());
	}
}
