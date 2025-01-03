package 이은지.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char[] chars, password;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		chars = new char[C];
		password = new char[L];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chars);

		comb(0, 0);
	}

	private static void comb(int start, int idx) {

		if (idx == L) {
			if (check()) {
				System.out.println(password);
			}

			return;
		}

		for (int i = start; i < C; i++) {
			password[idx] = chars[i];
			comb(i + 1, idx + 1);
		}
	}

	private static boolean check() {
		int a = 0; // 모음
		int b = 0; // 자음

		for (char c : password) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				a++;
			} else {
				b++;
			}
		}

		if (a >= 1 && b >= 2) {
			return true;
		}

		return  false;
	}

}
