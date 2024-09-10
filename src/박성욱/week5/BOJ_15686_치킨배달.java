package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_15686_치킨배달 {
	static int [][] arr;
	static int n,m;
	static boolean visit[][];
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static ArrayList<Integer> resarr = new ArrayList<>();
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nmarr [] = br.readLine().trim().split(" ");
		n = Integer.parseInt(nmarr[0]);
		m = Integer.parseInt(nmarr[1]);
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0;i<n;i++) {
			String str[] = br.readLine().trim().split(" ");
			for (int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(arr[i][j] ==1) {
					visit = new boolean[n][n];
					bfs(i,j);
				}
			}
		}
		
	}
	private static void bfs(int i, int j) {
		Queue<int []> q = new LinkedList<>();
		int cnt = 0;
		q.add(new int[] {i,j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int now [] = q.poll();
			int r = now[0];
			int c = now[1];
			
			for(int k = 0;k<4;k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr<0 || nc<0 || nr>=n || nc>=n || visit[nr][nc] ) {
					continue;
				}
				
				if(arr[nr][nc] == 2) {
					cnt = Math.abs(nr-i) + Math.abs(nc-j);
					resarr.add(cnt);
					break;
				}
				visit[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
			
			if(cnt !=0) {
				break;
			}
			
		}
	}
}
