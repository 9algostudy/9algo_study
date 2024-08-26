package 이은지.week4;

import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

    static ArrayList<Integer>[] arr;
    static int[] dis;
    static ArrayList<Integer> result;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        result = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        bfs();

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        dis = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dis[i] = -1;
        }

        q.add(X);
        dis[X]++;

        while(!q.isEmpty()) {

            int node = q.poll();

            if (dis[node] > K) {
                continue;
            }

            if (dis[node] == K) {
                result.add(node);
            }

            for (int i : arr[node]) {
                if (dis[i] == -1) {
                    q.add(i);
                    dis[i] = dis[node] + 1;
                }
            }
        }
    }

}
