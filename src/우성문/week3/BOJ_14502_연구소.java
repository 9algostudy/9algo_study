package 우성문.week3;

import java.util.*;
import java.io.*;

public class BOJ_14502_연구소 {
	static int[][] map;
	static int n;
	static int m;
	static ArrayList<int[]> virusCoordiante = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			line = br.readLine().trim().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] == 0) {
				} else if (map[i][j] == 2) {
					virusCoordiante.add(new int[] { i, j });
				}
			}
		}
		selectWall(0);
		System.out.println(max);
	}

	static void selectWall(int wallCnt) {
		if (wallCnt == 3) {
			searchByBFS();
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					selectWall(wallCnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void searchByBFS() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}

		for (int[] virus : virusCoordiante) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(virus);
			while (!queue.isEmpty()) {
				int[] coordi = queue.poll();
				for (int i = 0; i < 4; i++) {
					int row = coordi[0] + dx[i];
					int col = coordi[1] + dy[i];
					if (!isBound(row, col) || temp[row][col] != 0) {
						continue;
					}
					temp[row][col] = 2;
					queue.add(new int[] { row, col });
				}
			}
		}

		int safeArea = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					safeArea++;
				}
			}
		}
		max = Math.max(max, safeArea);
	}

	static boolean isBound(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

}
