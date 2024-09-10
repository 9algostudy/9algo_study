package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

    static int N, M;
    static int[][] graph;
    static int[] plan;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        plan = new int[M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        dfs(plan[0] - 1);


        boolean result = true;
        for (int i = 0; i < M; i++) {
            if (!visited[plan[i] - 1]) {
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static void dfs(int start) {

        visited[start] = true;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

}
