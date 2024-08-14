package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
	static boolean[] check;
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(1000);

		String[] line = br.readLine().trim().split(" ");

		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		

		for (int i = 0; i < m; i++) {
			line = br.readLine().trim().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			ArrayList<Integer> aList = graph.containsKey(a) ? graph.get(a) : new ArrayList<>();
			aList.add(b);
			graph.put(a, aList);
			ArrayList<Integer> bList = graph.containsKey(b) ? graph.get(b) : new ArrayList<>();
			bList.add(a);
			graph.put(b, bList);
		}
		count = 0;
		for(int i = 0;i<n;i++) {
			if(!graph.containsKey(i)) {
				continue;
			}
			check = new boolean[n];
			count=0;
			dFS(i);
			if(count==4) {
				break;
			}
		}
		sb.append(count==4?1:0);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	static void dFS(int visit) {
		if (check[visit]) {
			return;
		}
		count++;
		check[visit] = true;
		ArrayList<Integer> list = graph.get(visit);
		if (list != null) {
			for (int next : list) {
				if (!check[next]) {
					dFS(next);
					break;
				}
			}
		}
	}
	
	static void bFS(int visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(visit);
		check[visit] = true;
		while (!queue.isEmpty()) {
			int next = queue.poll();
			ArrayList<Integer> list = graph.get(next);
			if (list != null) {
				for (int room : list) {
					if (!check[room]) {
						check[room] = true;
						queue.add(room);
					}
				}
			}
		}
	}
}
