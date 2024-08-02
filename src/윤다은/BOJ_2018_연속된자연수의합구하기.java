package 윤다은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class BOJ_2018_연속된자연수의합구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1, sum = 0;
		int N = Integer.parseInt(br.readLine());
		
		int a = N/2 + 1;
		int last = a;
		
		if (N <= 2) {
			System.out.println(1);
			return;
		}
		
		while (a > 0) {
			if (sum < N) {
				sum += a;
				a--;
			}
			else {
				sum -= last--;
			}
			
			if (sum == N) {
				count++;
				sum -= last--;
			}
		}
		
		System.out.println(count);
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		int ans = 0, t = 0;
//		
//		for(int i = 1; (t = i*(i+1)/2) <= N; i++) {
//			if((N-t) % i == 0) ans++;
//		}
//		
//		System.out.println(ans);
//	}
}
