package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

    static int N;
    static int[][] graph, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];

            dfs(i);

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int V) {
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            if (graph[V][i] == 0) {
                continue;
            }

            visited[i] = true;
            dfs(i);
        }
    }

}
