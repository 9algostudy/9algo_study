package 우성문.week7;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_7576_토마토 {
	static int n,m,max=0;
	static int[][] map;
	static boolean[][] visited;
 	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week7/BOJ_7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().trim().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);
		map = new int[n][m];
		visited = new boolean[n][m];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			};
		});
		
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j =0;j<m;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j]==1) {
					visited[i][j] = true;
					pq.offer(new int[] {i,j,0});
				}else if(map[i][j]==-1) {
					visited[i][j] = true;
				}
			}
		}
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			max = Math.max(max, current[2]);
			for(int i=0;i<4;i++) {
				int x = current[0]+dx[i];
				int y = current[1]+dy[i];
				if(isBound(x, y)&&!visited[x][y]&&map[x][y]==0) {
					visited[x][y] = true;
					pq.offer(new int[] {x,y,current[2]+1});
				}
			}
		}
		boolean flag = true;
		for(int i = 0;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(!visited[i][j]) {
					flag = false;
					break;
				}
			}
		}
		System.out.println(flag?max:-1);
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=m);
	}
}
