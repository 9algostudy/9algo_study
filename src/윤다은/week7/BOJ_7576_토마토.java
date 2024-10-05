package 윤다은.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[][] tomato = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(s[j]);
				if (tomato[i][j] == 1) {
					queue.offer(new int[] {i, j});
				} else if (tomato[i][j] == 0) cnt++;
			}
		}
		
		int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		int day = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			day++;
			
			while (size-- > 0) {
				int[] tmp = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = tmp[0] + d[i][0];
					int nc = tmp[1] + d[i][1];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || tomato[nr][nc] != 0) continue;
					tomato[nr][nc] = 1;
					cnt--;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		System.out.println(cnt == 0 ? day : -1);
	}
}
