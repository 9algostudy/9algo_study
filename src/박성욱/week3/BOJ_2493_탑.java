package 박성욱.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str [] = br.readLine().trim().split(" ");
		
		StringBuilder sb = new StringBuilder(10000000);
		int [] height = new int [n];
		Stack<Integer> stk = new Stack<>();
		for(int i = 0;i<str.length;i++) {
			height[i] = Integer.parseInt(str[i]);
		}
		
		
		for(int i = 0;i<str.length;i++) {
			//스택이 비어있찌 않고, 스택 마지막보다 내께 크다면 팝
			while(!stk.isEmpty() && height[stk.peek()] < height[i]) {
				stk.pop();
			}
			// 그 꼭대기 출력하고, 인덱스 번호 출력
			if(!stk.isEmpty()){
				sb.append(stk.peek() + 1).append(" ");
			}
			else
				sb.append(0).append(" ");
			stk.push(i);
		}
		
		System.out.println(sb.toString());
		
		
	}
}
