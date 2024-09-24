package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_14501_퇴사{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		int p, d;
		List<int[]>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			d = Integer.parseInt(s[0]);
			p = Integer.parseInt(s[1]);
			
			if (i+d > N) continue;
			list[i+d].add(new int[] {d, p});
		}
		
		int[] res = new int[N+1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			res[i] = max;
			for (int[] a : list[i]) {
				res[i] = Math.max(res[i], res[i-a[0]]+a[1]);
			}
			max = res[i];
		}
		
		System.out.println(max);
	}
}
