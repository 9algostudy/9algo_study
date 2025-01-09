package 이은지.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    static class Pipe {
        int x, y, dir, count;

        public Pipe(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N - 1][N - 1] == 1) { // 가지치기 안하면 시간초과 남
            System.out.println(0);
            return;
        }

        Queue<Pipe> q = new LinkedList<>();
        q.offer(new Pipe(0, 1, 0, 1));

        int result = 0;

        while (!q.isEmpty()) {

            Pipe pipe = q.poll();
            int dir = pipe.dir;
            int x = pipe.x;
            int y = pipe.y;
            int count = pipe.count;

            if (x == N - 1 && y == N - 1) {
                result += count;
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (Math.abs(dir - i) >= 2) { // 0 -> 2, 2 -> 0으로 못감
                    continue;
                }

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= N || ny >= N || map[nx][ny] == 1) {
                    continue;
                }

                if (i == 1 && (map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1)) {
                    continue;
                }


                q.offer(new Pipe(nx, ny, i, count));

            }

        }

        System.out.println(result);

    }
}
