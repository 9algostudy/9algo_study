package 이은지.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {

	static int N;
	static long[] arr;
	static long min, result1, result2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			binarySearch(i);
		}

		System.out.println(result1 + " " + result2);
	}

	private static void binarySearch(int idx) {
		int left = idx + 1;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = Math.abs(arr[idx] + arr[mid]);

			if (min > sum) {
				min = sum;
				result1 = arr[idx];
				result2 = arr[mid];
			}

			if (arr[mid] >= -arr[idx]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

	}

}
