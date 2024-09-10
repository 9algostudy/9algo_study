package 윤다은.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1261_알고스팟 {
	static class Block implements Comparable<Block>{
		int x;
		int y;
		int w;
		
		public Block(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Block o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[1]);
		int M = Integer.parseInt(s[0]);
		
		int[][] map = new int[N][M];
		String st;
		for (int i = 0; i < N; i++) {
			st = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Block> queue = new PriorityQueue<>();
		queue.offer(new Block(0, 0, 0));
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		visited[0][0] = 0;
		
		while (!queue.isEmpty()) {
			Block b = queue.poll();
//			visited[b.x][b.y] = b.w;
			if (b.x == N-1 && b.y == M-1) {
				System.out.println(b.w);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = b.x + d[i][0];
				int nc = b.y + d[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] <= b.w+map[nr][nc]) continue;
				visited[nr][nc] = b.w+map[nr][nc];
				queue.offer(new Block(nr, nc, b.w+map[nr][nc]));
			}
		}
	}
}
