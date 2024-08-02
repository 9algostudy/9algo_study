package 윤다은;

import java.io.*;
	
public class BOJ_11720_평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			sum += nums.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}
}
