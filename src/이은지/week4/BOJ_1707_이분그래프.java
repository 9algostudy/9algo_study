package 이은지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {

    static int V, E;
    static LinkedList<Integer>[] graph;
    static int[] depth;
    static boolean result;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new LinkedList[V + 1];

            for (int i = 1; i < V + 1; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }


            depth = new int[V + 1];
            result = true;

            q = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                if (depth[i] == 0) {
                    bfs(i);
                    if(!result) break;
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static void bfs(int ver) {
        q.offer(ver);
        depth[ver] = 1;

        while(!q.isEmpty()) {
            ver = q.poll();

            for (int num : graph[ver]) {
                if (depth[num] == 0) {
                    q.offer(num);
                    depth[num] = depth[ver] + 1;
                }
                else if ((depth[ver] % 2 == 0 && depth[num] % 2 == 0) || (depth[ver] % 2 == 1 && depth[num] % 2 == 1)) {
                    result = false;
                    return;
                }
            }
        }

    }

}
