package 이은지.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2342_DDR{

    static int size;
    static int[][][] dp;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        list.add(0);

        while (true){
            int i = Integer.parseInt(st.nextToken());

            if (i == 0) {
                break;
            }

            list.add(i);
        }

        size = list.size();
        dp = new int[size][5][5]; // index, 현재 왼쪽, 현재 오른쪽

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 987654321;
                }
            }

        }

        dp[0][0][0] = 0;
        int min = 987654321;

        for (int idx = 0; idx < size - 1; idx++) {
            int end = list.get(idx + 1); // 다음 타겟

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int now = dp[idx][i][j];

                    if (end != j) { // 두발이 동일하지 않도록 => 왼발 움직이는 경우
                        dp[idx + 1][end][j] = Math.min(dp[idx + 1][end][j], now + cost(i, end));
                    }

                    if (end != i) { // 두발이 동일하지 않도록 => 오른발 움직이는 경우
                        dp[idx + 1][i][end] = Math.min(dp[idx + 1][i][end], now + cost(j, end));
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[size - 1][i][j]);
            }
        }

        System.out.println(min);
    }

    private static int cost(int start, int end) {
        if (start == end) {
            return 1;
        } else if (start == 0) {
            return 2;
        } else if (Math.abs(start - end) == 1 || Math.abs(start - end) == 3) {
            return 3;
        } else {
            return 4;
        }
    }

}
