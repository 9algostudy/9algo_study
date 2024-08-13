package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 생성
        int n = Integer.parseInt(br.readLine()); // 첫 번째 입력 줄에서 배열의 크기를 읽음
        int[] arr = new int[n]; // 입력된 수들을 저장할 배열
        int[] result = new int[n]; // 결과를 저장할 배열
        String[] input = br.readLine().split(" "); // 두 번째 입력 줄에서 수들을 읽어 공백으로 분리

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]); // 입력된 수들을 배열에 저장
        }

        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택 생성

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) { // 스택이 비어있지 않고, 현재 숫자가 스택의 최상단 숫자보다 큰 경우
                result[stack.pop()] = arr[i]; // 스택의 최상단 인덱스를 팝하고, 해당 인덱스의 결과 값을 현재 숫자로 설정
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; // 스택에 남아있는 인덱스들은 오른쪽에 자신보다 큰 숫자가 없으므로 -1로 설정
        }

        StringBuilder sb = new StringBuilder(); // 결과를 출력할 StringBuilder 생성
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" "); // 결과 배열의 값을 StringBuilder에 추가
        }

        System.out.println(sb.toString()); // 결과를 출력
    }
}