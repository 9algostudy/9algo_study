package 이은지.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        sb = new StringBuilder();

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void bfs(int V) {
        visited[V] = true;
        queue.offer(V);

        while (!queue.isEmpty()) {
            V = queue.poll();
            sb.append(V).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[i][V] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    private static void dfs(int V) {

        visited[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[i][V] == 1) {
                dfs(i);
            }
        }
    }
}
