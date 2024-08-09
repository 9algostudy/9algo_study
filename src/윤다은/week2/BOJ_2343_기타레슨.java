package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
	static int M;
	static int min = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] times = new int[N];
		
		st = new StringTokenizer(br.readLine());
		times[0] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N; i++) {
			times[i] = times[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	static void dfs(int start, int end, int depth, int max) {
		if (depth == M) {
			if (min > max) {
				min = max;
			}
			return;
		}
		if ()
	}
}
