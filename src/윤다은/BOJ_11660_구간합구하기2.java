package 윤다은;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ_11660_구간합구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(100);
        int sum;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N+1][N+1];
        int x1, x2, y1, y2;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                nums[i][j] = nums[i][j-1] + nums[i-1][j] - nums[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sum = nums[x2][y2] + nums[x1-1][y1-1] - nums[x1-1][y2] - nums[x2][y1-1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
