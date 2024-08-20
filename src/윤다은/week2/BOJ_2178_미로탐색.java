package 윤다은.week2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] maze = new String[N];
		int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		int[][] visited = new int[N][M];
		
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine();
		}
		
		int nextX, nextY;
		queue.offer(new Point(0, 0));
		visited[0][0] = 1;
		Point p;
		
		while (!queue.isEmpty()) {
			p = queue.poll();
			
			if (p.x == N-1 && p.y == M-1) break;
			
			for (int i = 0; i < 4; i++) {
				nextX = p.x + d[i][0];
				nextY = p.y + d[i][1];
				
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || maze[nextX].charAt(nextY) == '0' || visited[nextX][nextY] != 0) continue;
				
				visited[nextX][nextY] = visited[p.x][p.y] + 1;
				queue.add(new Point(nextX, nextY));
			}
		}
		
		System.out.println(visited[N-1][M-1]);
	}
}
