package 우성문.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935_문자열폭발 {
	static BufferedReader br;
	static String str, bombStr;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		bombStr = br.readLine();
		int bombStrLen = bombStr.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			result.append(str.charAt(i));

			if (result.length() >= bombStrLen) {
				boolean flag = true;

				for (int j = 0; j < bombStrLen; j++) {
					if (result.charAt(result.length() - bombStrLen + j) != bombStr.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					result.delete(result.length() - bombStrLen, result.length());
				}
			}
		}

		// 결과 출력
		System.out.println(result.length() == 0 ? "FRULA" : result.toString());
	}
}
