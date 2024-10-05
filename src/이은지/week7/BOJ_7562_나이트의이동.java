package 이은지.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

    static int x, y, tx, ty;
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[N][N];
            graph = new int[N][N];

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x, y});
            visited[x][y] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                        graph[nx][ny] = graph[x][y] + 1;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }

                    if (nx == tx && ny == ty) {
                        break;
                    }
                }
            }

            System.out.println(graph[tx][ty]);
        }
    }

}
