package 우성문.week4;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
	static HashMap<Integer, ArrayList<Integer>> weights = new HashMap<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		int v = Integer.parseInt(line[0]);
		int e = Integer.parseInt(line[1]);
		int start = Integer.parseInt(br.readLine().trim());
		for(int i = 0;i<e;i++) {
			line = br.readLine().trim().split(" ");
			int startNode = Integer.parseInt(line[0]);
			int endNode = Integer.parseInt(line[1]);
			int weight = Integer.parseInt(line[2]);
			ArrayList<Integer> nodeList = graph.containsKey(startNode)?graph.get(startNode):new ArrayList<>();
			nodeList.add(endNode);
			ArrayList<Integer> wegihtList = weights.containsKey(startNode)?weights.get(startNode):new ArrayList<>();
			wegihtList.add(weight);
			graph.put(startNode, nodeList);
			weights.put(startNode, wegihtList);
		}
		
	}
}
