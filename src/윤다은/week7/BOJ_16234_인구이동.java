package 윤다은.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16234_인구이동 {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		
		int[][] map = new int[N][N];
		parent = new int[N*N];
		int[] sum = new int[N*N];
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int diff, a, b;
		boolean stop = false;
		while (!stop) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					parent[i*N+j] = i*N+j;
				}
			}
			
			stop = true;
			for (int i = 0; i < N-1; i++) {
				for (int j = 0; j < N-1; j++) {
					diff = Math.abs(map[i][j] - map[i+1][j]);
					if (diff >= L && diff <= R) {
						stop = false;
						a = i*N+j; b = i*N+N+j;
						if (findP(a) != findP(b)) {
							sum[parent[a]] += sum[parent[b]];
							union(a, b);
						}
					}
				}
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			if (!stop) {
				int[][] visited = new int[N][N];
				for (int i = 0;  i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (visited[i][j] == 0) {
							int p = findP(i*N+j);
							queue.offer(i*N+j);
							while (!queue.isEmpty()) {
								int x = queue.poll();
							}
						}
					}
				}
			}
		}
		
	}
	
	static int findP(int a) {
		if (parent[a] == a) return a;
		return parent[a] = findP(parent[a]);
	}
	
	static void union(int a, int b) {
		parent[parent[b]] = parent[a];
	}
}
