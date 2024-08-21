package 박성욱.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_11724_연결요소의개수 {
	static int cnt = 0;
	static boolean[] visited;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmarr = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmarr[0]);
		int m = Integer.parseInt(nmarr[1]);
		visited = new boolean[n + 1];
		list=  new LinkedList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new LinkedList<>();
		}
		// 양방향 그래프 추가하기
		for (int i = 0; i < m; i++) {
			String str[] = br.readLine().trim().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			list[u].add(v);
			list[v].add(u);
		}
		int cnt = 0;
		for(int i = 1;i< n+1;i++) {
			if(visited[i]==false) {
				cnt++;
				DFS(i);
			}
		}
		System.out.println(cnt);
	}

	static void DFS(int v) {
		if(visited[v]==true) {
			return;
		}
		visited[v] = true;
		for(int i : list[v]) {
			if(visited[i]== false) 
				DFS(i);
		}
	}
}

