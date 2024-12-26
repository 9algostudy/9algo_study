package 윤다은.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String bomb = br.readLine();

		int bombLength = bomb.length();

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			st.add(s.charAt(i));

			int stSize = st.size();
			if (stSize >= bombLength) {
				int j = 0;
				for (; j < bombLength; j++) {
					if (bomb.charAt(j) != st.get(stSize-bombLength+j)) break;
				}

				if (j == bombLength) {
					for (j = 0; j < bombLength; j++) {
						st.pop();
					}
				}
			}
		}

		for (int i = 0; i < st.size(); i++) {
			sb.append(st.get(i));
		}
		System.out.println(sb.isEmpty() ? "FRULA" : sb);	//Java8에서는 sb.isEmpty() 안됨
	}
}



//public class BOJ_9935_문자열폭발 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		String s = br.readLine();
//		String bomb = br.readLine();
//
//		int[] list = new int[bomb.length()];
//		Arrays.fill(list, -1);
//
//		int cur = 0;
//		for (int i = 1; i < bomb.length(); i++) {
//			if (bomb.charAt(i) == bomb.charAt(cur)) {
//				list[i] = cur;
//				cur++;
//			}
//			else {
//				while (cur > 0) {
//					System.out.println(cur);
//					cur = list[i-1] + 1;
//					if (bomb.charAt(i) == bomb.charAt(cur)) break;
//				}
//				list[i] = cur;
//			}
//		}
//
//		System.out.println(Arrays.toString(list));
//
//		Stack<Character> stack = new Stack<>();
//		Stack<Integer> integerStack = new Stack<>();
//		cur = 0;
//		for (int i = 0; i < s.length(); i++) {
//			System.out.println(cur + " " + s.charAt(i));
//			stack.add(s.charAt(i));
//			integerStack.add(cur);
//
//			if (s.charAt(i) == bomb.charAt(cur)) {
//				cur++;
//			} else {
//				while (cur > 0) {
//					cur = list[i-1] + 1;
//					if (s.charAt(i) == bomb.charAt(cur)) break;
//				}
//			}
//
//			if (cur == bomb.length()) {
//				for (int j = 0; j < bomb.length(); j++) {
//					stack.pop();
//					integerStack.pop();
//				}
//				cur = integerStack.peek();
//			}
//
//			if (stack.isEmpty()) {
//				System.out.println("FRULA");
//				return;
//			}
//		}
//
//		while (!stack.isEmpty()) {
//			sb.append(stack.pop());
//		}
//
//		System.out.println(sb.reverse());
//	}
//
//}
