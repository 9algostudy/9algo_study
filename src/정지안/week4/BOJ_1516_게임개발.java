package 정지안.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] inDegree;
    static Building[] buildings;
    static List<ArrayList<Integer>> edgeList = new ArrayList<>();

    static class Building implements Comparable<Building> {
        int num;
        int time;

        Building(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Building o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }

        inDegree = new int[n + 1]; // 특정 건물을 짓기 전에 먼저 지어야 할 건물의 개수
        buildings = new Building[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            buildings[i] = new Building(i, time);

            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) break;

                edgeList.get(num).add(i);

                inDegree[i]++;
            }

        }

        String ans = topologicalSort();
        bw.write(ans);
        bw.flush();
        bw.close();
        br.close();
    }//main()

    private static String topologicalSort() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Building> pq = new PriorityQueue<>();

        //먼저 지어야할 건물이 없는 건물을 큐에 집어넣는다.
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.offer(buildings[i]);
            }
        }

        while(!pq.isEmpty()) {
            int current = pq.poll().num;

            for(int next: edgeList.get(current)) {
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    buildings[next].time += buildings[current].time;
                    pq.offer(buildings[next]);
                }
            }
        }

        // 특정 건물을 짓는 데 걸린 시간을 출력.
        for (int i = 1; i <= n; i++) {
            sb.append(buildings[i].time + "\n");
        }


        return sb.toString();
    }
}
