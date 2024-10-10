package 이은지.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {

    static int N, H;
    static int[] bottom, ceil;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[N / 2];
        ceil = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            bottom[i] = a;
            ceil[i] = b;
        }

        Arrays.sort(bottom);
        Arrays.sort(ceil);

        int min = 987654321;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            int d = binarySearch(0, N / 2, bottom, i);
            int u = binarySearch(0, N / 2, ceil, H - i + 1);

            if (min == d + u) {
                cnt++;
                continue;
            }

            if (min > d + u) {
                min = d + u;
                cnt = 1;
            }

        }
        System.out.println(min + " " + cnt);

    }

    private static int binarySearch(int left, int right, int[] arr, int height) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= height) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return arr.length - right;
    }
}
