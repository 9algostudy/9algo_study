package 우성문.week4;

import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().trim().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int x = Integer.parseInt(line[3]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            line = br.readLine().trim().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            graph.get(start).add(end);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();

            for (int nextCity : graph.get(currentCity)) {
                if (distance[nextCity] == -1) { // 아직 방문하지 않은 도시
                    distance[nextCity] = distance[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
