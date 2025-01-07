package 윤다은.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_17396_백도어 {
    static class Node implements Comparable<Node> {
        int b;
        Long t;

        public Node(int b, Long t) {
            this.b = b;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return (this.t - o.t) > 0 ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        List<int[]>[] list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        arr[N-1] = 0;

        int a, b, t;
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");

            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            t = Integer.parseInt(s[2]);

            list[a].add(new int[]{b, t});
            list[b].add(new int[]{a, t});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0L));
        arr[0] = 1;

        Long[] res = new Long[N];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0L;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (tmp.b == N-1) {
                System.out.println(tmp.t);
                return;
            }

            for (int[] next : list[tmp.b]) {
                b = next[0];
                t = next[1];

                if (arr[b] == 1 || res[b] <= tmp.t+t) continue;
                res[b] = tmp.t+t;
                pq.offer(new Node(b, res[b]));
            }
        }

        System.out.println(-1);
    }
}