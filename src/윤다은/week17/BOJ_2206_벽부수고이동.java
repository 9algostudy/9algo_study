package 윤다은.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206_벽부수고이동 {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static class Node {
        int broken;
        int r;
        int c;

        public Node(int broken, int r, int c) {
            this.broken = broken;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        String s;
        map = new int[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        visited[0][0][0] = 1;

        Node tmp;
        int nr, nc;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            int r = tmp.r;
            int c = tmp.c;

            if (r == N-1 && c == M-1) {
                System.out.println(visited[r][c][tmp.broken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                nr = r + dir[i][0];
                nc = c + dir[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == 1 && tmp.broken == 0 && visited[nr][nc][1] == 0) {
                    visited[nr][nc][1] = visited[r][c][0]+1;
                    queue.offer(new Node(1, nr, nc));
                } else if (map[nr][nc] == 0 && visited[nr][nc][tmp.broken] == 0) {
                    visited[nr][nc][tmp.broken] = visited[r][c][tmp.broken]+1;
                    queue.offer(new Node(tmp.broken, nr, nc));
                }
            }
        }

        System.out.println(-1);
    }
}
