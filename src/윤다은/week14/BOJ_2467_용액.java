package 윤다은.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] list = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = list.length-1;

		int min = Integer.MAX_VALUE;
		int res1 = 0, res2 = 0;
		while (left < right) {
			int tmp = list[left] + list[right];

			if (min > Math.abs(tmp)) {
				res1 = list[left];
				res2 = list[right];
				min = Math.abs(tmp);
				if (tmp == 0) break;
			}

			else if (tmp > 0) right--;
			else left++;
		}

		System.out.println(res1 + " " + res2);
	}

}
