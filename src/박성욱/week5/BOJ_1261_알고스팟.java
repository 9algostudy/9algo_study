package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1261_알고스팟 {
	static int [][] arr;
	static boolean [][] visit;
	static int [][] dir;
	static int n,m,res;
	static int dr [] = {1,-1,0,0};
	static int dc [] = {0,0,-1,1};
	static PriorityQueue<block> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().trim().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		arr= new int [n][m];
		visit = new boolean[n][m];
		dir = new int [n][m];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				dir[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		for(int i = 0;i<n;i++) {
			String ar = br.readLine();
			for(int j = 0;j<m;j++) {
				arr[i][j] = ar.charAt(j) - '0';
			}
		}
		res = n*m;
		dir[0][0] = 0;
		dik(0,0,0);
		
		System.out.println(res);
	}
	
	private static void dik(int i, int j, int x) {
		pq.add(new block (i,j,x));
//		visit[i][j] = true;
		while(!pq.isEmpty()) {
			block now = pq.poll();
			
			int r = now.r;
			int c = now.c;
			int w = now.w;
			if( r == n-1 && c == m-1) {
				res = w;
			}
			
			for(int k = 0;k<4;k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				
				
				if(nr>=n || nc>=m || nr<0 || nc<0 || visit[nr][nc]) {
					continue;
				}
				
				if(dir[nr][nc] > now.w + arr[nr][nc]) {
					dir[nr][nc] = now.w + arr[nr][nc];
					pq.add(new block(nr,nc,now.w+arr[nr][nc]));
				}
			}
			
			
		}
	}

//	private static void dfs(int i, int j,int cnt) {
//		if(i == n-1 && j == m-1) {
//			res = Math.min(res, cnt);
//			return;
//		}
//		visit[i][j] = true;
//		for(int k = 0;k<4;k++) {
//			int nr = i + dr[k];
//			int nc = j + dc[k];
//			if(nr>=n || nc>=m || nr<0 || nc<0 ||visit[nr][nc]) {
//				continue;
//			}
//			
//			if(arr[nr][nc] == 1) {
//				dfs(nr,nc,cnt+1);
//			}
//			else
//			dfs(nr,nc,cnt);
//		}
//		visit[i][j] = false;
//		
//	}

}

class block implements Comparable<block>{
	int r;
	int c;
	int w;
	
	public block(int r, int c, int w) {
		this.r = r;
		this.c = c;
		this.w = w;
	}

	@Override
	public int compareTo(block o) {
		return this.w - o.w;
	}
	
	
}
