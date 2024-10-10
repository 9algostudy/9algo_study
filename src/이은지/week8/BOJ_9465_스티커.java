package 이은지.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    dp[1][i] = arr[1][i];
                    dp[0][i] = arr[0][i];
                }

                else if (i == 1) {
                    dp[0][i] = dp[1][i - 1] + arr[0][i];
                    dp[1][i] = dp[0][i - 1] + arr[1][i];
                }

                else {
                    dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[1][i - 2] + arr[0][i]);
                    dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[0][i - 2] + arr[1][i]);
                }

            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
