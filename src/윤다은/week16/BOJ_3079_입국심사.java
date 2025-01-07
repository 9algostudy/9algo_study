package 윤다은.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3079_입국심사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);


        int[] arr = new int[N];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
        }

        //min*M 결과값이 long인 경우 min이 int로 선언되어 있으면 오버플로우가 발생하기 때문에 right가 long이라도 오류가 난다
        //따라서 min도 long으로 선언해주어야 한다.
        long left = 1, right = min*M;
        long mid, res;
        while (left < right) {
            mid = (left + right) / 2;

            res = 0;
            for (int i = 0; i < N; i++) {
                res += mid/arr[i];
            }

            if (res < M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}
