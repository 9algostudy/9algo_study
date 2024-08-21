package 우성문.week1;

import java.io.*;
import java.util.*;

public class BOJ_17298_오큰수구하기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        String[] nums = br.readLine().trim().split(" ");
        int[] result = new int[n];
        
        
        // 인덱스 값을 저장할 stack
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않고 현재 숫자가 스택의 top에 있는 인덱스가 가리키는 숫자보다 클 경우
            while (!stack.isEmpty() && Integer.parseInt(nums[stack.peek()]) < Integer.parseInt(nums[i])) {
                result[stack.pop()] = Integer.parseInt(nums[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
