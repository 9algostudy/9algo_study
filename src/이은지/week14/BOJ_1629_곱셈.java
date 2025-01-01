package 이은지.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {

	static long A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(remain(B));
	}

	private static long remain(long n) {
		if (n == 1) {
			return A % C;
		}

		long temp = remain(n / 2);

		if (n % 2 == 0) {
			return temp * temp % C;
		} else {
			return (temp * temp % C) * A % C;
		}
	}

}
