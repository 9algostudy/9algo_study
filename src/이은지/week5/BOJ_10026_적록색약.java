package 이은지.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {

    static int N, result1, result2;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String read = br.readLine();

            for (int j = 0; j < N; j++) {
                char a = read.charAt(j);
                graph[i][j] = a;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result1++;
                }

                if (graph[i][j] == 'R') {
                    graph[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result2++;
                }
            }
        }

        sb.append(result1).append(" ").append(result2);
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;
        char color = graph[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && graph[nx][ny] == color) {
                dfs(nx, ny);
            }
        }

    }

}
