package 우성문.week13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();

	static int n,cnt;
	static String[] map;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/input/BOJ_2667_단지번호붙이기.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new String[n];
		visited = new boolean[n][n];

		for(int i = 0;i<n;i++) {
			map[i] = br.readLine();
		}

		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(map[i].charAt(j) == '1'&&!visited[i][j]) {
					cnt = 0;
					visited[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i,j});
					while(!q.isEmpty()) {
						int[] current = q.poll();
						cnt++;
						for(int idx=0;idx<4;idx++) {
							int x = current[0]+dx[idx];
							int y = current[1]+dy[idx];
							if (isBound(x,y)&&map[x].charAt(y)=='1'&&!visited[x][y]) {
								q.add(new int[]{x,y});
								visited[x][y] = true;
							}
						}
					}
					list.add(cnt);
				}
			}
		}

		Collections.sort(list);
		sb.append(list.size()).append('\n');
		for(Integer cnt:list) sb.append(cnt).append('\n');
		System.out.println(sb);
	}

	static boolean isBound(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}
}
