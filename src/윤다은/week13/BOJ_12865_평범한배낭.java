package 윤다은.week13;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] bag = new int[K+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			for (int j = K; j >= w; j--) {
				bag[j] = Math.max(bag[j], bag[j-w]+c);
			}
		}

		System.out.println(bag[K]);
	}
}