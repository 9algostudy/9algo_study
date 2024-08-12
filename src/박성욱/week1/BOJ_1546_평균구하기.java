package 박성욱.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1546_평균구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] str = br.readLine().split(" ");
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		double max = 0;
		for (double x : arr) {
			max = Math.max(max, x);
		}
		Arrays.sort(arr);

		double sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] / max * 100);
			sum += arr[i];
		}

		double res = sum / n;

		System.out.println(res);
	}

}
