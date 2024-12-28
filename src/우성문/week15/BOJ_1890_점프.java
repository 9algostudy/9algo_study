package 우성문.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, moveLen;
    static long[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                moveLen = Integer.parseInt(st.nextToken());
                for (int idx = 0; idx < 2; idx++) {
                    int row = i + moveLen * dx[idx];
                    int col = j + moveLen * dy[idx];
                    if (isBound(row, col)&&dp[i][j]>0&&moveLen>0) {
                        dp[row][col]+=dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }

    static boolean isBound(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }
}
