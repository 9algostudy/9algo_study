package 우성문.week12;

import java.io.*;
import java.util.*;

public class BOJ_11053_가장긴증가하는부분수열 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n;
    static int[] sequence;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input/BOJ_11053_가장긴증가하는부분수열.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n];
        Arrays.fill(dp, 1);
        sequence = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
