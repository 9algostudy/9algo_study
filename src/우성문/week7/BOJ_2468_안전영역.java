package 우성문.week7;

import java.io.*;
import java.util.*;

public class BOJ_2468_안전영역 {
	static int n,mh=0,max=1;
	static int[][] map;
	static boolean[][] visited;
 	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week7/BOJ_2468_안전영역.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j =0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				mh = Math.max(mh, map[i][j]);
			}
		}
		
		while(mh>0) {
			visited = new boolean[n][n];
			int cnt = 0;
			for(int i = 0;i<n;i++) {
				for(int j =0;j<n;j++) {
					if(!visited[i][j]&&map[i][j]>mh) {
						cnt++;
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i,j});
						visited[i][j] = true;
						while(!q.isEmpty()) {
							int[] current = q.poll();
							for(int idx = 0;idx<4;idx++) {
								int x = current[0]+dx[idx];
								int y = current[1]+dy[idx];
								if(isBound(x, y)&&!visited[x][y]&&map[x][y]>mh) {
									visited[x][y] = true;
									q.offer(new int[] {x,y});
								}
							}
						}
					}
				}
			}
			max = Math.max(max, cnt);
			mh--;
		}
		System.out.println(max);
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=n);
	}
}
