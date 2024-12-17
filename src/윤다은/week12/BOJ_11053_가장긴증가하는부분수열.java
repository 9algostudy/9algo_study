package 윤다은.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");

		int[] nums = new int[N];
		int[] res = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(s[i]);

			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					res[i] = Math.max(res[i], res[j] + 1);
					max = Math.max(max, res[i]);
				}
			}
		}

		System.out.println(max+1);
	}
}
