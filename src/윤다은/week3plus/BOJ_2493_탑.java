package 윤다은.week3plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int n, res;
		Stack<int[]> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(s[i]);
			
			while (!stack.isEmpty() && stack.peek()[0] < n) {
				stack.pop();
			}
			
			sb.append(stack.isEmpty()?0:stack.peek()[1]+1).append(" ");
			stack.push(new int[] {n, i});
		}
		
		System.out.println(sb);
	}
}
