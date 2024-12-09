package 우성문.week12;

import java.io.*;
import java.util.*;

public class BOJ_1647_도시분할계획 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,m;
    static int total = 0;
    static int max = 0;
    static int[] parents;
    static int[] rank;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input/BOJ_1647_도시분할계획.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i = 1;i<=n;i++) parents[i] = i;
        rank = new int[n+1];

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            if(find(current[0])!=find(current[1])){
                union(current[0],current[1]);
                total += current[2];
                max = Math.max(max,current[2]);
            }
        }
        System.out.println(total-max);
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parents[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parents[rootA] = rootB;
            } else {
                parents[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}

