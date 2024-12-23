package 우성문.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n,m,max=0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				visited[i][j] = true;
				dfs(i,j,map[i][j],1);
				visited[i][j] = false;
				TBlock(i,j);
			}
		}
		System.out.println(max);
	}

	static void dfs(int x, int y,int total, int size){
		if(size >= 4){
			max = Math.max(max,total);
			return;
		}
		for(int i=0;i<4;i++) {
			int row = x + dx[i];
			int col = y + dy[i];
			if (isBound(row, col) && !visited[row][col]) {
				visited[row][col] = true;
				dfs(row, col, total + map[row][col], size + 1);
				visited[row][col] = false;
			}
		}
	}

	static void TBlock(int x,int y){
		ArrayList<Integer> list = new ArrayList<>();
		int total = map[x][y];
		for(int i=0;i<4;i++) {
			int row = x + dx[i];
			int col = y + dy[i];
			if (isBound(row, col)) {
				total += map[row][col];
				list.add(map[row][col]);
			}
		}
		if(list.size()==3){
			max = Math.max(max,total);
		}else if(list.size()==4){
			for(Integer num:list){
				max = Math.max(max,total-num);
			}
		}
	}


	static boolean isBound(int x,int y){
		return !(x<0||x>=n||y<0||y>=m);
	}
}
