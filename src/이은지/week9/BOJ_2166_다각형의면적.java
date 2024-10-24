package 이은지.week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {

	static int N;
	static long[][] position;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		position = new long[N + 1][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			position[i][0] = Integer.parseInt(st.nextToken());
			position[i][1] = Integer.parseInt(st.nextToken());
		}

		position[N][0] = position[0][0];
		position[N][1] = position[0][1];

		double sum = 0;

		for (int i = 0; i < N; i++) {
			sum += (position[i][0] * position[i + 1][1]);
			sum -= (position[i][1] * position[i + 1][0]);
		}

		System.out.printf("%.1f", Math.abs(sum / 2.0));

	}

}

