package 윤다은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(100);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		sums[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int i, j;
		while (M-- > 0)	 {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append(sums[j]-sums[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}
