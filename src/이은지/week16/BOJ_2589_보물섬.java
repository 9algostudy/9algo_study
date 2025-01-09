package 이은지.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

    static int N, M, MAX;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Position {
        int x, y, count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        MAX = 0;

        for (int i = 0; i < N; i++) {
            String read = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = read.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(MAX);
    }

    private static void bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y, 0));

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Position pos = q.poll();
            MAX = Math.max(MAX, pos.count);

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 'W') {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Position(nx, ny, pos.count + 1));
            }
        }
    }


}
