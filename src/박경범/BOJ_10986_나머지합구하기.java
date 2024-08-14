package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10986_나머지합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] arr = new int[N];
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 나머지 카운트 배열
        long[] modCount = new long[M];
        long prefixSum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            prefixSum += arr[i];
            int mod = (int) (prefixSum % M);
            
            // 나머지가 음수일 경우, M을 더해 양수로 만듭니다.
            if (mod < 0) {
                mod += M;
            }

            // 나머지가 0인 경우는 그 자체로 나누어 떨어지는 부분합을 의미합니다.
            if (mod == 0) {
                result++;
            }

            // 나머지가 같은 이전 누적합의 빈도만큼 결과를 증가시킵니다.
            result += modCount[mod];
            // 현재 나머지의 빈도를 증가시킵니다.
            modCount[mod]++;
        }

        System.out.println(result);
    }
}
