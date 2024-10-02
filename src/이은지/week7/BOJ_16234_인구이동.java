package 이은지.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

    static int N, L, R, result;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;



        while(isUnite()) {
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            result++;
        }

        System.out.println(result);
    }

    private static boolean isUnite() { // 연합 맺을 게 더 있는지 확인하는 메서드
        boolean unite = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        int diff = Math.abs(arr[nx][ny] - arr[i][j]);
                        if (diff >= L && diff <= R) {
                            unite = true;
                            return unite;
                        }
                    }
                }
            }
        }

        return unite;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        int sum = arr[x][y];

        q.offer(new int[] {x, y});
        visited[x][y] = true;
        list.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            x = pos[0];
            y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(arr[nx][ny] - arr[x][y]);

                        if (diff >= L && diff <= R) {
                            pos = new int[] {nx, ny};
                            q.offer(pos);
                            visited[nx][ny] = true;
                            sum += arr[nx][ny];
                            list.add(pos);
                        }
                    }
                }
            }
        }

        int popul = sum / list.size();

        for (int[] pos : list) {
            x = pos[0];
            y = pos[1];

            arr[x][y] = popul;
        }
    }


}


