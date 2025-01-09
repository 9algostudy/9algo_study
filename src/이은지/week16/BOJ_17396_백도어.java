package 이은지.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396_백도어 {

    static int N, M;
    static int[] arr;
    static long[] minTimes;
    static ArrayList<ArrayList<Node>> list;

    static class Node implements Comparable<Node> {
        int end;
        long time;

        public Node(int end, long time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (time - o.time > 0) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        list = new ArrayList<>();
        minTimes = new long[N];

        Arrays.fill(minTimes, Long.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, t));
            list.get(b).add(new Node(a, t));
        }

        dijkstra();

        System.out.println(minTimes[N - 1] == Long.MAX_VALUE ? -1 : minTimes[N - 1]);

    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];

        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.end]) continue;
            visited[node.end] = true;

            for (Node next : list.get(node.end)) {

                if (arr[next.end] == 1 && next.end != N - 1) {
                    continue;
                }

                if (minTimes[next.end] > minTimes[node.end] + next.time) {
                    minTimes[next.end] = minTimes[node.end] + next.time;
                    pq.offer(new Node(next.end, minTimes[next.end]));
                }
            }
        }
    }


}

//import java.util.*;
//
//public class Main {
//
//    static int n, m;
//    static boolean[] sight;
//    static ArrayList<Node>[] list;
//    static long[] dist;
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        //입력
//        n = scan.nextInt();
//        m = scan.nextInt();
//
//        sight = new boolean[n];
//        for(int i = 0; i < n; i++) {
//            int flag = scan.nextInt();
//            if(flag == 1) sight[i] = true;
//            else sight[i] = false;
//        }
//
//        list = new ArrayList[n];
//        for(int i = 0; i < n; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for(int i = 0; i < m; i++) {
//            int s = scan.nextInt();
//            int e = scan.nextInt();
//            int c = scan.nextInt();
//            list[s].add(new Node(e, c));
//            list[e].add(new Node(s, c));
//        }
//        //입력 끝
//
//        dist = new long[n];
//        Arrays.fill(dist, Long.MAX_VALUE);
//        dist[0] = 0;
//        dijkstra();
//
//        if(dist[n - 1] == Long.MAX_VALUE) System.out.println("-1");
//        else System.out.println(dist[n - 1]);
//    }
//
//    public static void dijkstra() {
//        PriorityQueue<Node> q = new PriorityQueue<>();
//        boolean[] visited = new boolean[n];
//        q.offer(new Node(0, 0));
//
//        while(!q.isEmpty()) {
//            Node current = q.poll();
//
//            if(visited[current.node]) continue;
//            visited[current.node] = true;
//
//            for(int i = 0; i < list[current.node].size(); i++) {
//                Node next = list[current.node].get(i);
//                if(next.node != n - 1 && sight[next.node]) continue;
//                if(dist[next.node] > dist[current.node] + next.cost) {
//                    dist[next.node] = dist[current.node] + next.cost;
//                    q.offer(new Node(next.node, dist[next.node]));
//                }
//            }
//        }
//    }
//
//    public static class Node implements Comparable<Node> {
//        int node;
//        long cost;
//
//        public Node(int node, long cost) {
//            this.node = node;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Node n) {
//            if(this.cost - n.cost > 0) return 1;
//            else return -1;
//        }
//    }
//}

