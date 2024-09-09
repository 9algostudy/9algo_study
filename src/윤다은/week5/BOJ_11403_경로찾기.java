package 윤다은.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11403_경로찾기 {
	static int N;
	static int[][] adjM;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjM = new int[N][N];
		
		String[] s;
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				adjM[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adjM[i][j] == 1)
					dfs(i, j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjM[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int i, int j) {
		for (int n = 0; n < N; n++) {
			if (adjM[j][n] == 1 && adjM[i][n] == 0) {
				adjM[i][n] = 1;
				dfs(i, n);
			}
		}
	}
}
