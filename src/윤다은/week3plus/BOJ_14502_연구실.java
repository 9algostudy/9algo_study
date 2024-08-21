package 윤다은.week3plus;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502_연구실 {
	static int N, M, min = 100, cleanCnt = 0;
	static int[][] map;
	static ArrayList<Point> virus = new ArrayList<>();
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1},  {1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		
		//map 저장
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				//기존에 바이러스 없는 공간 개수 세기
				if (map[i][j] == 0) cleanCnt++;
				//바이러스면 ArrayList에 추가
				else if (map[i][j] == 2) virus.add(new Point(i, j));
			}
		}
		cleanCnt -= 3;	
		//벽 세우는 부분. 브루트포스 알고리즘
		dfs(0);
		//기존에 바이러스 없는 공간에서 최소로 바이러스 퍼트린 수 구하기
		System.out.println(cleanCnt-min);
	}

	static void dfs(int n) {
		if (n == 3) {
			//벽 세개 다 세우면 바이러스 퍼트리기
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(n+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		Point p;
		
		//맵 copy
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		//queue에 바이러스 넣기
		int cnt = 0;
		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}
		
		//queue가 빌 때까지 바이러스 퍼트리기. 퍼트린 개수 센다
		while (!queue.isEmpty()) {
			p = queue.poll();
			for (int j = 0; j < 4; j++) {
				int newx = p.x + d[j][0];
				int newy = p.y + d[j][1];
				if (newx < 0 || newx >= N || newy < 0 || newy >= M || tmp[newx][newy] != 0) continue;
				tmp[newx][newy] = 2;
				cnt++;
				queue.add(new Point(newx, newy));
			}
		}
		//퍼트린 바이러스의 최소값 구하기
		if (min > cnt) min = cnt;
	}
}
