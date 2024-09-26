package 과제문제_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2468_안전영역 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] visited, map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		String[] s;
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int cnt = 0, max = 0;
		for (int i = 0; i <= 100; i++) {
			visited = new int[N][N];
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (visited[j][k] == 0 && map[j][k] > i) {
						cnt++;
						dfs(j, k, i);
					}
				}
			}
			max = Math.max(max, cnt);
		}
	
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int n) {
		visited[x][y] = 1;
		
		int newx, newy;
		for (int i = 0; i < 4; i++) {
			newx = x + d[i][0];
			newy = y + d[i][1];
			
			if (newx < 0 || newx >= N || newy < 0 || newy >= N || visited[newx][newy] == 1 || map[newx][newy] <= n) continue;
			dfs(newx, newy, n);
		}
	}
}
