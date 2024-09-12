package 우성문.week5;

import java.io.*;

public class BOJ_10026_적록색약 {
	static int n,cnt;
	static String[] lines;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_10026_적록색약.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine().trim());
		lines = new String[n];
		for(int i = 0;i<n;i++) lines[i] = br.readLine().trim();
		
		map = new int[n][n];
		cnt = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(map[i][j]==0) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		System.out.print(cnt+" ");
		map = new int[n][n];
		cnt = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(map[i][j]==0) {
					cnt++;
					bfs2(i,j);
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs(int x,int y) {
		map[x][y] = cnt;
		char ch = lines[x].charAt(y);
		for(int i = 0;i<4;i++) {
			int row = x + dx[i];
			int col = y + dy[i];
			if(isBound(row, col)&&map[row][col]==0&&lines[row].charAt(col)==ch) {
				bfs(row,col);
			}
		}
	}
	
	static void bfs2(int x,int y) {
		map[x][y] = cnt;
		char ch = lines[x].charAt(y);
		if(ch == 'B') {
			for(int i = 0;i<4;i++) {
				int row = x + dx[i];
				int col = y + dy[i];
				if(isBound(row, col)&&map[row][col]==0&&lines[row].charAt(col)==ch) {
					bfs2(row,col);
				}
			}
		}else {
			for(int i = 0;i<4;i++) {
				int row = x + dx[i];
				int col = y + dy[i];
				if(isBound(row, col)&&map[row][col]==0&&lines[row].charAt(col)!='B') {
					bfs2(row,col);
				}
			}
		}
	}
	
	static boolean isBound(int x,int y) {
		return !(x>=n||x<0||y>=n||y<0);
	}
}
