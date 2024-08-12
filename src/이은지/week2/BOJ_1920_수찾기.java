package 이은지.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(find(num));
        }

    }

    private static int find(int num) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) {
                return 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return 0;
    }
}
