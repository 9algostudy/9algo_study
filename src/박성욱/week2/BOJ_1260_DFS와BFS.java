package 박성욱.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_DFS와BFS {
	static ArrayList<Integer> [] arr;
	static boolean [] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nmv = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmv[0]);
		int m = Integer.parseInt(nmv[1]);
		int v = Integer.parseInt(nmv[2]);
		
		arr = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i = 0;i<=n;i++) {
			arr[i] = new ArrayList<>();
		}
		

		for(int i = 0;i<m;i++) {
			String[] nmarr= br.readLine().trim().split(" ");
			int a = Integer.parseInt(nmarr[0]);
			int b = Integer.parseInt(nmarr[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i = 0;i<=n;i++) {
			Collections.sort(arr[i]);
		}
		
		visit = new boolean[n+1];
		dfs(v);
		System.out.println();
		
		visit = new boolean[n+1];
		bfs(v);
		
	}

	private static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		
		visit[v] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			System.out.print(now + " ");
			for (int x : arr[now]) {
				if(visit[x] == false) {
					visit[x] = true;
					que.add(x);
				}
				
			}
		}
		
		
	}

	private static void dfs(int v) {
		System.out.print(v + " ");
		visit[v] = true;
		
		for (int x : arr[v]) {
			if(visit[x]==false) {
				dfs(x);
			}
		}
		
	}
}
