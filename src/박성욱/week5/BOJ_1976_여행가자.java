package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1976_여행가자 {
    static int n, m;
    static int[][] rc;
    static ArrayList<Integer>[] arr;
    static int[] plan;
    static boolean flag;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        rc = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                rc[i][j] = Integer.parseInt(str[j]);
                if (rc[i][j] != 0) {
                    arr[i + 1].add(j + 1);
                }
            }
        }

        String[] str1 = br.readLine().trim().split(" ");
        plan = new int[str1.length];
        for (int i = 0; i < plan.length; i++) {
            plan[i] = Integer.parseInt(str1[i]);
        }

        boolean possible = true; 
        for (int i = 0; i < plan.length - 1; i++) {
            visit = new boolean[n + 1]; 
            flag = false; 
            dfs(plan[i], plan[i + 1]); 
            
            if (!flag) { 
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    private static void dfs(int start, int end) {
        visit[start] = true;

        if (start == end) {
            flag = true;
            return;
        }

        for (int x : arr[start]) {
            if (!visit[x]) {
                dfs(x, end);
                if (flag) 
                	return; 
            }
        }
    }
}
