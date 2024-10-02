package 우성문.week7;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562_나이트의이동 {
	static int n;
	static int[] start,end;
	static boolean[][] visited;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week7/BOJ_7562_나이트의이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc =1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine().trim());
			visited = new boolean[n][n];
			line = br.readLine().trim().split(" ");
			start = new int[] {Integer.parseInt(line[0]),Integer.parseInt(line[1])};
			line = br.readLine().trim().split(" ");
			end = new int[] {Integer.parseInt(line[0]),Integer.parseInt(line[1])};
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {start[0],start[1],0});
			visited[start[0]][start[1]] = true;
			while(!q.isEmpty()) {
				int[] current = q.poll();
				if(end[0]==current[0]&&end[1]==current[1]) {
					sb.append(current[2]).append("\n");
					break;
				}
				for(int i = 0;i<8;i++) {
					int x = current[0] + dx[i];
					int y = current[1] + dy[i];
					if(isBound(x, y)&&!visited[x][y]) {
						visited[x][y] = true;
						q.offer(new int[] {x,y,current[2]+1});
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=n);
	}
}
