package 박성욱.week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396_백도어 {
    static int n, m;
    static int[] arr;
    static long[] dist;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {
        int end;
        long cost;

        Node(int end, long cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost - o.cost > 0) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmarr = br.readLine().split(" ");
        n = Integer.parseInt(nmarr[0]);
        m = Integer.parseInt(nmarr[1]);
        arr = new int[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        String[] strarr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strarr[i]);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if ((arr[a] == 0 || a == n - 1) && (arr[b] == 0 || b == n - 1)) {
                graph.get(a).add(new Node(b, t));
                graph.get(b).add(new Node(a, t));
            }
        }

        dist = new long[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;

        long result = dijkstra(0);
        if( result == Long.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }

    private static long dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
            long curcost = curNode.cost;

            if (curcost > dist[cur]) continue;

            for (Node next : graph.get(cur)) {
                if (dist[next.end] > dist[cur] + next.cost) {
                    dist[next.end] = dist[cur] + next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
        return dist[n - 1];
    }
}
