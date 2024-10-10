package 이은지.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_24954_물약구매 {

    static boolean[] visited;
    static int min, N;
    static int[] cost;
    static int[][] discount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cost = new int[N + 1];
        discount = new int[N + 1][N + 1];

        for (int i= 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int M = Integer.parseInt(br.readLine());

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                discount[i][a] = b; // i번째 물약을 사면 a 물약이 b만큼 할인

            }

        }

        min = 987654321;
        visited = new boolean[N + 1];
        recur(0, 0);

        System.out.println(min);
    }

    private static void recur(int depth, int sum) {
        if (depth >= N) {
            min = Math.min(sum, min);
            return;
        }

        if (sum >= min) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int originCost[] = Arrays.copyOf(cost, N + 1);

            for (int j = 1; j <= N; j++) {
                cost[j] -= discount[i][j];
                if (cost[j] <= 0) {
                    cost[j] = 1;
                }
            }

            recur(depth + 1, sum + cost[i]);

            visited[i] = false;
            cost = Arrays.copyOf(originCost, N + 1);
        }


    }
}
