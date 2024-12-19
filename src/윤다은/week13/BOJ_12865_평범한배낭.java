package 윤다은.week13;

import java.io.*;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		int[] bag = new int[K+1];
		bag[0] = 0;

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);

			for (int j = K; j >= w; j--) {
				bag[j] = Math.max(bag[j], bag[j-w]+Integer.parseInt(s[1]));
			}
		}

		System.out.println(bag[K]);
	}
}