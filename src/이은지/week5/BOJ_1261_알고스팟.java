package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

    static int N, M, min;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position implements Comparable<Position>{
        int x, y, wall;

        public Position(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        @Override
        public int compareTo(Position p) {
            return wall - p.wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = read.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(min);
    }

    private static void bfs() {
        PriorityQueue<Position> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new Position(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Position p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                min = p.wall;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >=N || ny >= M) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    q.offer(new Position(nx, ny, p.wall));
                } else if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    q.offer(new Position(nx, ny, p.wall + 1));
                }

                visited[nx][ny] = true;

            }
        }
    }
}
