package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static Stack<Integer> stack;
	public static int checkOrder = 0;
	public static int[] order;
	public static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb  = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] number = new int[n];
		order = new int[n];

		stack = new Stack<>();

		for(int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0; i < n; i++) {
			number[i] = i+1;
		}

		for(int i = 0; i < order.length; i++) {
			stack.push(number[i]);
			sb.append("+").append("\n");

			checkOrder();
		}
		
		if(stack.size() == 0) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

	public static void checkOrder() {
		if(stack.peek() == order[checkOrder]) {
			stack.pop();
			sb.append("-").append("\n");
			checkOrder++;

			if(stack.size() != 0)
				// 재귀함수 호출
				checkOrder();
		}
	}
}
