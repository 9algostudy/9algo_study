package 윤다은.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17396_백도어 {
    static class Node {
        int b;
        long t;

        public Node(int b, long t) {
            this.b = b;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        List<Node>[] list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        arr[N-1] = 0;

        int a, b;
        long t;
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            t = Integer.parseInt(s[2]);

            list[a].add(new Node(b, t));
            list[b].add(new Node(a, t));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.t, o2.t);
            }
        });
        pq.offer(new Node(0, 0L));
        arr[0] = 1;

        long[] res = new long[N];
        int[] visited = new int[N];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0L;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (tmp.b == N-1) {
                System.out.println(tmp.t);
                return;
            }

            if (visited[tmp.b] == 1) continue;
            visited[tmp.b] = 1;

            for (Node next : list[tmp.b]) {
                b = next.b;
                t = next.t;

                if (arr[b] == 1 || res[b] <= tmp.t+t) continue;
                res[b] = tmp.t+t;
                pq.offer(new Node(b, res[b]));
            }
        }

        System.out.println(-1);
    }
}