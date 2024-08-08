package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int u, v;
		
		int cnt = 0;
		
		int[][] con = new int[N+1][N+1];
		int[] group = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			con[u][v] = 1;
			con[v][u] = 1;
		}
		
		for (int i =1; i<=N; i++) {
			if (group[i] == 1) continue;
			
			cnt++;
			queue.add(i);
			group[i] = 1;
			while (!queue.isEmpty()) {
				int k = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (group[j] == 1) continue;
					if (con[k][j] == 1) {
						group[j] = 1;
						queue.add(j);
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
