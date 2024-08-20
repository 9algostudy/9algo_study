package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// DFS 구현문제 -> 깊이 우선 탐색 문제
public class BOJ_11724_연결요소의개수 {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line;

		line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		A = new ArrayList[N+1];
		visited = new boolean[N+1];

		// 인접 리스트 초기화
		for(int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);
			
			A[start].add(end);
			A[end].add(start);
		}
		
		int count = 0;
		
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}

		}
		
		System.out.println(count);
	}
	
	public static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		
		visited[v] = true;
		for(int i : A[v]) {
			if(visited[i] == false) {
				DFS(i);
			}
		}
	}
}
