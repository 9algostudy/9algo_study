package 박성욱.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();


		String res = solv(str,pattern);
		if (res.isEmpty()) {
			System.out.println("FRULA");
		}
		else
			System.out.println(res);

	}

	private static String solv(String str, String pattern) {
		Stack<Character> stk = new Stack<Character>();
		int len = pattern.length();
		for (int i = 0; i < str.length(); i++) {
			stk.push(str.charAt(i));

			if (stk.size() >= len) {
				boolean matches = true;
				for (int j = 0; j < len; j++) {
					if (stk.get(stk.size() - len + j) != pattern.charAt(j)) {
						matches = false;
						break;
					}
				}
				if (matches) {
					for (int j = 0; j < len; j++) {
						stk.pop();
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (char c : stk) {
			result.append(c);
		}

		return result.toString();
	}
}


