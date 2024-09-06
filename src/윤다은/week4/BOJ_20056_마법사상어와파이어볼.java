package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_20056_마법사상어와파이어볼 {
	
	static class fireball {
		int x;
		int y;
		int m;
		int s;
		int d;
		
		public fireball(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N, M, K;
	static ArrayList<fireball> balls = new ArrayList<>();
	static ArrayList<fireball>[][] map;
	static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			balls.add(new fireball(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));
		}
		
		for (int i = 0; i < K; i++) {
			move();
		}
		
		int res = 0;
		for (fireball fb : balls) res += fb.m;
		
		System.out.println(res);
	}
	
	public static void move() {
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (fireball fb : balls) {
			int x = (fb.x + d[fb.d][0]*fb.s)%N;
			if (x < 0) x += N;
			int y = (fb.y + d[fb.d][1]*fb.s)%N;
			if (y < 0) y += N;
			
			fb.x = x;
			fb.y = y;
			
			map[x][y].add(fb);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 1) {
					int m = 0;
					int s = 0;
					boolean even = false, odd = false;
					for (fireball fb : map[i][j]) {
						m += fb.m;
						s += fb.s;
						if (fb.d%2 == 0) even = true;
						else odd = true;
						balls.remove(fb);
					}
					
					m /= 5;
					if (m == 0) continue;
					s /= map[i][j].size();
					
					if (even && odd) {
						for (int k = 1; k < 8; k+=2) {
							balls.add(new fireball(i, j, m, s, k));
						}
					} else {
						for (int k = 0; k < 7; k+=2) {
							balls.add(new fireball(i, j, m, s, k));
						}
					}
				}
			}
		}
	}
}
