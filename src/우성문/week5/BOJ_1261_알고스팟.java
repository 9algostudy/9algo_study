package 우성문.week5;

import java.io.*;
import java.util.*;

public class BOJ_1261_알고스팟 {
	static int n,m,cnt;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] minDist;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_1261_알고스팟.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);
		map = new int[n][m];
		minDist = new int[n][m];
		for(int i = 0;i<n;i++) {
			String str = br.readLine().trim();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j)-'0';
				minDist[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(minDist[n-1][m-1]);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		minDist[0][0] = 0;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int currentDist = minDist[current[0]][current[1]];
			for(int i=0;i<4;i++) {
				int row = current[0] + dx[i];
				int col = current[1] + dy[i];
				if(isBound(row, col)) {
					if(map[row][col]==1&&minDist[row][col]>currentDist+1) {
						minDist[row][col] = currentDist+1;
						q.offer(new int[] {row,col});
					}else if(map[row][col]==0&&minDist[row][col]>currentDist) {
						minDist[row][col] = currentDist;
						q.offer(new int[] {row,col});
					}
				}
			}
		}
	}
	
	static boolean isBound(int x,int y) {
		return !(x>=n|x<0||y>=m||y<0);
	}
}
