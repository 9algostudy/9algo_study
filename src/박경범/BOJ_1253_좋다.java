package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1253_좋다 {
    // 결과 값을 저장할 변수
    public static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 N 입력받기
        int N = Integer.parseInt(br.readLine());
        int[] Ai = new int[N];

        // 수열의 원소들을 입력받기
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            Ai[i] = Integer.parseInt(input[i]);
        }

        // 수열 정렬
        Arrays.sort(Ai);

        // 각 원소에 대해 두 수의 합으로 나타낼 수 있는지 확인
        for (int k = 0; k < N; k++) {
            int target = Ai[k]; // 현재 목표 값 설정
            int i = 0; // 왼쪽 포인터
            int j = N - 1; // 오른쪽 포인터

            while (i < j) {
                // 왼쪽 포인터가 목표 값을 가리킬 때 포인터 이동
                if (i == k) {
                    i++;
                    continue;
                }
                // 오른쪽 포인터가 목표 값을 가리킬 때 포인터 이동
                if (j == k) {
                    j--;
                    continue;
                }

                int sum = Ai[i] + Ai[j]; // 두 수의 합 계산

                if (sum == target) { // 두 수의 합이 목표 값과 같은 경우
                    result++;
                    break; // 다음 목표 값으로 이동
                } else if (sum < target) { // 두 수의 합이 목표 값보다 작은 경우
                    i++; // 왼쪽 포인터를 오른쪽으로 이동
                } else { // 두 수의 합이 목표 값보다 큰 경우
                    j--; // 오른쪽 포인터를 왼쪽으로 이동
                }
            }
        }

        // 결과 값 출력
        System.out.println(result);
    }
}