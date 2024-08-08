package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static String[] maze;
	static int N, M, count = 0, min;
	static int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new String[N];
		visited = new boolean[N][M];
		min = M*N;
		
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine();
		}
		
		
		
		System.out.println(min);
	}
}
