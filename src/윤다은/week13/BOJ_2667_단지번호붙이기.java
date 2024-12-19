package 윤다은.week13;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}

		int cnt = 0;
		PriorityQueue<Integer> pri = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					pri.offer(bfs(i, j));
				}
			}
		}

		System.out.println(cnt);
		while (!pri.isEmpty()) {
			System.out.println(pri.poll());
		}
	}

	static int bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(i, j));
		map[i][j] = 0;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			cnt++;

			for (int b = 0; b < 4; b++) {
				int newX = p.x+d[b][0];
				int newY = p.y+d[b][1];
				if (newX < 0 || newX >= N || newY < 0 || newY >= N || map[newX][newY] == 0) continue;
				queue.offer(new Point(newX, newY));
				map[newX][newY] = 0;
			}
		}

		return cnt;
	}
}