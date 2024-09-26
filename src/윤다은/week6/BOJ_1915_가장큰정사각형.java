package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1915_가장큰정사각형{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		String st;
		int[][] arr = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = st.charAt(j-1)-'0';
			}
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1])) + 1;
					max = Math.max(arr[i][j], max);
				}
			}
		}
		
		System.out.println(max*max);
	}
}
