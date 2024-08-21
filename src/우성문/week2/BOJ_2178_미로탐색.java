package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
	static int[][] map;
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		sb.append(bfs());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		// x좌표, y좌표, 이동거리
		queue.add(new int[]{0, 0, 1});
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] nowNode = queue.poll();
			int x = nowNode[0];
			int y = nowNode[1];
			int cnt = nowNode[2];

			if (x == n - 1 && y == m - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int row = x + dx[i];
				int col = y + dy[i];
				if (checkBound(row, col) && map[row][col] == 1 && !visited[row][col]) {
					visited[row][col] = true;
					queue.add(new int[]{row, col, cnt + 1});
				}
			}
		}
		return 0;
	}

	static boolean checkBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}