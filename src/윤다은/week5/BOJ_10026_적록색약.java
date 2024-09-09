package 윤다은.week5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] map2 = new int[N][N];
		
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'R') {
					map[i][j] = map2[i][j] = 1;
				}
				else if (s.charAt(j) == 'B') {
					map[i][j] = map2[i][j] = 2;
				}
				else {
					map[i][j] = 3;
					map2[i][j] = 1;
				}
			}
		}
		
		int cnt1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					cnt1++;
					bfs(map[i][j], i, j, map);
				}
			}
		}
		
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] != 0) {
					cnt2++;
					bfs(map2[i][j], i, j, map2);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	static void bfs(int n, int r, int c, int[][] map) {
		int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c));
		map[r][c] = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.x + d[i][0];
				int nc = p.y + d[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != n) continue;
				map[nr][nc] = 0;
				queue.offer(new Point(nr, nc));
			}
		}
	}
}
