package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] count;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            count[b]++;
        }

        bfs();

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int V = q.poll();
            sb.append(V).append(" ");

            ArrayList<Integer> list = graph.get(V);

            for (int i : list) {
                count[i]--;

                if (!visited[i] && count[i] == 0) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
