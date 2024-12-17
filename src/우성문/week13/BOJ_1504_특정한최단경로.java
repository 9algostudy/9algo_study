package 우성문.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n,m, v1, v2;
	static List[] graph = new List[801];

	static class Node implements Comparable<Node> {
		int end;
		int distance;

		public Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/input/BOJ_1504_특정한최단경로.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(m==0){
			System.out.println(-1);
			return;
		}
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, distance));
			graph[end].add(new Node(start, distance));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		long case1 = minimumDistance(1,v1)+minimumDistance(v1,v2)+minimumDistance(v2,n);
		long case2 = minimumDistance(1,v2)+minimumDistance(v2,v1)+minimumDistance(v1,n);
		long result = Math.min(case1,case2);

		System.out.println(result>=Integer.MAX_VALUE?"-1":result);

	}

	static long minimumDistance(int start,int end){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distances = new int[n+1];
		Arrays.fill(distances, Integer.MAX_VALUE);

		distances[start] = 0;
		pq.add(new Node(start, distances[start]));

		while(!pq.isEmpty()){
			Node current = pq.poll();
			if(current.distance > distances[current.end]){
				continue;
			}

			for(Object next : graph[current.end]){
				int nextEnd = ((Node)next).end;
				int nextDistance = current.distance + ((Node)next).distance;

				if(distances[nextEnd] > nextDistance){
					distances[nextEnd] = nextDistance;
					pq.add(new Node(nextEnd, nextDistance));
				}
			}
		}
		return distances[end];
	}
}