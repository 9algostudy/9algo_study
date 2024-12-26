package 윤다은.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1629_곱셈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		long A = Long.parseLong(s[0]);
		long B = Long.parseLong(s[1]);
		long C = Long.parseLong(s[2]);

		System.out.println(multiply(A, B, C));
	}

	static long multiply(long A, long B, long C) {
		if (B == 1) return A%C;
		long res = multiply(A, B/2, C)%C;
		if (B%2 == 0) return (res*res)%C;
		else return ((res*res)%C*A)%C;
	}
}
