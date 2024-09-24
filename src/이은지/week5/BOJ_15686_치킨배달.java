package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

    static int N, M, min;
    static int[][] graph;
    static ArrayList<int[]> houses;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    houses.add(new int[] {i, j});
                }
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < houses.size(); i++) {
            int[] house = houses.get(i);
            int x = house[0];
            int y = house[1];

            bfs(x, y);
        }


    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int count = 0;

        while (!q.isEmpty()) {
            int[] house = q.poll();
            x = house[0];
            y = house[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (graph[nx][ny] == 2) {

                }
            }
        }
    }
}
