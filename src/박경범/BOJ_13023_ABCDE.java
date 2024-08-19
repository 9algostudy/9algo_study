package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_13023_ABCDE {
	static ArrayList<Integer>[] friends;
	static boolean[] visited;
	static int[][] result;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		sb.append(0);

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		friends = new ArrayList[N];
		visited = new boolean[N];

		for(int i = 0; i < friends.length; i++) {
			friends[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			friends[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			friends[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
		}

		for(int i = 0 ; i < N; i++) {
			DFS(i, 1);
			visited = new boolean[N];
		}
		
		System.out.println(sb.toString());
	}

	static void DFS(int V, int depth) {		

		visited[V] = true;
		
		if(depth == 5) {
			sb = new StringBuilder();
			sb.append(1);
			return;
		}

		for(int v : friends[V]) {
			if(!visited[v]) {
				DFS(v, depth+1);
			}
		}
		
		visited[V] = false;
	}
}