package 우성문.week12;

import java.io.*;
import java.util.*;

public class BOJ_2096_내려가기 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n ;
    static int[] nums;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input/BOJ_2096_내려가기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //st.nextToken()
        n = Integer.parseInt(st.nextToken());
        nums = new int[3]; // 행마다 입력받을 배열
        dp = new int[2][n+1][3]; // 0행 : 최솟값, 1행 : 최댓값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            solve(i);
        }
        Arrays.sort(dp[0][n]);
        Arrays.sort(dp[1][n]);
        System.out.println(dp[1][n][2]+" "+dp[0][n][0]);

    }

    public static void solve(int row){
        for(int i = 0;i<3;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = -1;j<2;j++){
                int idx = i+j;
                if(isBound(idx)){
                    // 최솟값 계산
                    min = Math.min(min,dp[0][row][idx]+nums[i]);
                    // 최댓값 계산
                    max = Math.max(max,dp[1][row][idx]+nums[i]);
                }
            }
            dp[0][row+1][i] = min;
            dp[1][row+1][i] = max;
        }
    }

    public static boolean isBound(int x){
        return !(0>x || x>=3);
    }
}
