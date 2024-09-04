package 이은지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[0][j] = arr[0][j];
                } else {
                    if (j == 0) {
                        dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                    } else if (j == 1) {
                        dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                    } else {
                        dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                    }
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }
        System.out.println(min);

    }
}
