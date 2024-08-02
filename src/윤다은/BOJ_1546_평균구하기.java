package 윤다은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class BOJ_1546_평균구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		double result = 0;
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			result = result + nums[i]*100.0/max;
		}
		
		System.out.println(result/N);
		
	}
}
