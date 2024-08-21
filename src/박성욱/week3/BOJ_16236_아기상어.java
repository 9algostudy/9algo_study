package 박성욱.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_16236_아기상어 {

	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int startrow= 0 ;
		int startcol = 0;
		boolean can = false;
		for (int i = 0; i < arr.length; i++) {
			String str[] = br.readLine().trim().split(" ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				if(arr[i][j] == 1) {
					can = true;
				}
				if(arr[i][j] == 9) {
					startrow = i;
					startcol = j;
				}
			}
		}
		//없을떄
		if(!can) {
			System.out.println(0);
			return;
		}
		
		dfs(startrow,startcol);
		

	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		
		
		
	}

}
