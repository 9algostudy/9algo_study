package 이은지.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        result = false;

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];

            dfs(i, 1);

            if (result) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);

    }

    private static void dfs(int V, int count) {

        if (count == 5) {
            result = true;
            return;
        }

        visited[V] = true;

        for (int i : graph[V]) {
            if (!visited[i]) {
                dfs(i, count + 1);
            }
        }

        visited[V] = false;
    }
}
