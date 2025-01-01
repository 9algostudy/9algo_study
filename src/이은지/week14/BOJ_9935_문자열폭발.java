package 이은지.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {

	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read = br.readLine();
		String bomb = br.readLine();

		int bombSize = bomb.length();

		stack = new Stack<>();

		for (int i = 0; i < read.length(); i++) {

			int count = 0;
			stack.push(read.charAt(i));

			if (stack.size() >= bombSize) {
				for (int j = 0; j < bombSize; j++) {
					if (stack.get(stack.size() - bombSize + j) == bomb.charAt(j)) {
						count++;
					}

					if (count >= bombSize) {
						for (int k = 0; k < bombSize; k++) {
							stack.pop();
						}
					}
				}
			}


		}
		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character c : stack) {
				sb.append(c);
			}

			System.out.println(sb);
		}
	}

}
