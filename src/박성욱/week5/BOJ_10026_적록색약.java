package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int onecnt, twocnt;
	static int n;
	static char[][] arr;
	static boolean visit[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					bfs(i, j);
					onecnt++;
				}
			}
		}
		visit = new boolean[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(!visit[i][j]) {
					blindbfs(i,j);
					twocnt++;
				}
			}
		}
		
		System.out.println(onecnt + " "+twocnt);

	}

	private static void blindbfs(int i, int j) {
		Queue<int []> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int now [] = q.poll();
			int r = now[0];
			int c = now[1];
			for(int k = 0;k<4;k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr>=n || nc>=n || nr<0 || nc<0 || visit[nr][nc]) {
					continue;
				}
	            if (arr[r][c] == 'B' && arr[nr][nc] == 'B' || (arr[r][c] != 'B' && (arr[nr][nc] == 'R' || arr[nr][nc] == 'G'))) {
	                visit[nr][nc] = true;
	                q.add(new int[]{nr, nc});
				}
			}
		}
}

	private static void bfs(int i, int j) {
		Queue<int []> q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int now [] = q.poll();
			int r = now[0];
			int c = now[1];
			for(int k = 0;k<4;k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if(nr>=n || nc>=n || nr<0 || nc<0 || visit[nr][nc]) {
					continue;
				}
				if(arr[nr][nc] == arr[r][c]) {
					visit[nr][nc] = true;
					q.add(new int[] {nr,nc});
				}
			}
		}
	}
}
