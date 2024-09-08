package 박성욱.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11403_경로찾기 {
    static int[][] arr;
    static int[][] res;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        res = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    dfs(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int i, int j) {
        for (int k = 0; k < n; k++) {
            if (arr[j][k] == 1 && res[i][k] == 0) {
                res[i][k] = 1;
                dfs(i, k);
            }
        }
    }
}
