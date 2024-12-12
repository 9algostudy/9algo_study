package 윤다은.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] s;

		int[] min = new int[3];
		int[] max = new int[3];
		int[] tmpMin = new int[3];
		int[] tmpMax = new int[3];

		s = br.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			min[i] = Integer.parseInt(s[i]);
			max[i] = min[i];
		}

		int a;
		for (int i = 1; i < N; i++) {
			s = br.readLine().split(" ");

			a = Integer.parseInt(s[0]);
			tmpMin[0] = Math.min(min[0], min[1]) + a;
			tmpMax[0] = Math.max(max[0], max[1]) + a;

			a = Integer.parseInt(s[1]);
			tmpMin[1] = Math.min(min[0], Math.min(min[1], min[2])) + a;
			tmpMax[1] = Math.max(max[0], Math.max(max[1], max[2])) + a;

			a = Integer.parseInt(s[2]);
			tmpMin[2] = Math.min(min[1], min[2]) + a;
			tmpMax[2] = Math.max(max[1], max[2]) + a;

			for (int j = 0; j < 3; j++) {
				min[j] = tmpMin[j];
				max[j] = tmpMax[j];
			}
		}

		System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
	}
}
