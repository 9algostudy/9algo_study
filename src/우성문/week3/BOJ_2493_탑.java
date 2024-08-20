package 우성문.week3;

import java.util.*;
import java.io.*;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());
		int[] heights = new int[n];
		int[] result = new int[n];
		
		String[] line = br.readLine().trim().split(" ");
		Stack<Integer> top = new Stack<>();


		for (int i = n - 2; i > 0; i--) {
			int num = Integer.parseInt(line[i]);
			StringBuilder temp = new StringBuilder();
			while (top.peek() < num) {
				top.pop();
				temp.append(i + 1).append(" ");
			}
			temp.append(sb.toString());
			sb = temp;
			top.push(num);
		}
		StringBuilder temp = new StringBuilder();
		while (!top.isEmpty()) {
			top.pop();
			temp.append("0 ");
		}
		temp.append("0 ");
		temp.append(sb.toString());

		bw.write(temp.toString());
		bw.flush();
		bw.close();
	}
}
/*
import java.util.Stack;
import java.util.Scanner;

public class LaserTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 탑의 수 N 입력
        int N = scanner.nextInt();
        int[] heights = new int[N];
        int[] result = new int[N];

        // 탑의 높이 입력
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        // 스택을 생성하여 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        // 오른쪽에서 왼쪽으로 탐색
        for (int i = N - 1; i >= 0; i--) {
            // 현재 탑의 높이
            int currentHeight = heights[i];
            
            // 스택의 최상위 탑과 비교
            while (!stack.isEmpty() && heights[stack.peek()] < currentHeight) {
                stack.pop();  // 더 낮은 탑은 제거
            }

            // 스택이 비어있지 않다면 수신하는 탑의 인덱스 저장
            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;  // 인덱스는 1부터 시작하므로 +1
            }

            // 현재 탑의 인덱스를 스택에 추가
            stack.push(i);
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
        
        scanner.close();
    }
}

*/