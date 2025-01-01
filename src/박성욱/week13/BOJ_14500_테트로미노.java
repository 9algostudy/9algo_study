package 박성욱.week13;

import java.io.*;
import java.util.*;

public class BOJ_14500_테트로미노 {
    static int n, m, maxSum = 0;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, board[i][j]);
                visited[i][j] = false;
                checkTShapes(i, j);
            }
        }

        System.out.println(maxSum);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 3) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void checkTShapes(int x, int y) {
        if (x >= 0 && x + 1 < n && y - 1 >= 0 && y + 1 < m) {
            int sum = board[x][y] + board[x + 1][y] + board[x][y - 1] + board[x][y + 1];
            maxSum = Math.max(maxSum, sum);
        }

        if (x - 1 >= 0 && x + 1 < n && y >= 0 && y + 1 < m) {
            int sum = board[x][y] + board[x - 1][y] + board[x + 1][y] + board[x][y + 1];
            maxSum = Math.max(maxSum, sum);
        }

        if (x >= 0 && x < n && y - 1 >= 0 && y + 2 < m) {
            int sum = board[x][y] + board[x][y - 1] + board[x][y + 1] + board[x][y + 2];
            maxSum = Math.max(maxSum, sum);
        }

        if (x - 1 >= 0 && x + 1 < n && y - 1 >= 0 && y < m) {
            int sum = board[x][y] + board[x - 1][y] + board[x + 1][y] + board[x][y - 1];
            maxSum = Math.max(maxSum, sum);
        }
    }
}
