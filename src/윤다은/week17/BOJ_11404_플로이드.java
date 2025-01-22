package 윤다은.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11404_플로이드 {
    static int n, m;
    static List<Node>[] graph;
    static int[] price;

    static class Node implements Comparable<Node> {
        int dest;
        int price;

        public Node(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        price = new int[n+1];

        graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            for (int j = 1; j <= n; j++) {
                sb.append(price[j] == Integer.MAX_VALUE ? 0 : price[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];

        Arrays.fill(price, Integer.MAX_VALUE);
        price[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.dest]) {
                continue;
            }
            visited[node.dest] = true;

            for (Node n : graph[node.dest]) {
                int newPrice = n.price + node.price;
                if (newPrice < price[n.dest]) {
                    price[n.dest] = newPrice;
                    pq.offer(new Node(n.dest, newPrice));
                }
            }
        }
    }
}
