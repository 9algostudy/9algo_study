package 이은지.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수{

    static long P = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i]++;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <10; j++) {
                if (j == 0) {
                    dp[i + 1][1] += (dp[i][0]) % P;
                } else if (j == 9) {
                    dp[i + 1][8] += (dp[i][9] % P);
                } else {
                    dp[i + 1][j - 1] += (dp[i][j] % P);
                    dp[i + 1][j + 1] += (dp[i][j] % P);
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        result %= P;

        System.out.println(result);
    }
}
