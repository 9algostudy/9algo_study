package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_DFS와BFS {
	static ArrayList<Integer>[] node;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		// 정점의 개수
		int N = Integer.parseInt(input[0]);
		// 간선의 개수
		int M = Integer.parseInt(input[1]);
		// 시작할 정점 번호
		int V = Integer.parseInt(input[2]);

		node = new ArrayList[N+1];
		visited = new boolean[N+1];

		for(int i = 1; i <= N; i++) {
			node[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			node[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			node[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		for(int i = 1; i <= N; i++) {
			node[i].sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
		}

		DFS(V);

		System.out.println();

		// 방문 배열 초기화
		visited = new boolean[N+1];

		BFS(V);
	}

	static void DFS(int V) {
		if(visited[V]) {
			return;
		}

		visited[V] = true;

		System.out.print(V + " ");

		for(int v : node[V]) {
			if(visited[v] == false) {
				DFS(v);
			}
		}
	}

	static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(V);

		visited[V] = true;
		System.out.print(V + " ");

		while(!queue.isEmpty()) {
			int current = queue.poll();

			for(int v : node[current]) {
				if(visited[v] == false) {
					visited[v] = true; 
					System.out.print(v + " ");

					queue.add(v);
				}
			}
		}
	}
}

