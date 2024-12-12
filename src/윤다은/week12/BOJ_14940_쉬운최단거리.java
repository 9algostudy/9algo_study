package 윤다은.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14940_쉬운최단거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		int[][] map = new int[n][m];
		int startx = -1, starty = -1;
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 2) {
					startx = i;
					starty = j;
				}
			}
		}

		int[][] visited = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startx, starty});
		visited[startx][starty] = 1;
		map[startx][starty] = 0;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dir[i][0];
				int dy = tmp[1] + dir[i][1];

				if (dx < 0 || dx >= n || dy < 0 || dy >= m || visited[dx][dy] == 1 || map[dx][dy] == 0)
					continue;

				visited[dx][dy] = 1;
				map[dx][dy] = map[tmp[0]][tmp[1]] + 1;
				queue.offer(new int[]{dx, dy});
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && map[i][j] == 1) sb.append(-1).append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
