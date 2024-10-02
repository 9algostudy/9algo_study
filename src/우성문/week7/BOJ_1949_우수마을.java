package 우성문.week7;

import java.io.*;
import java.util.*;

public class BOJ_1949_우수마을 {
    static int n;
    static int[] population;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("src/우성문/week7/BOJ_1949_우수마을.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        population = new int[n + 1];
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        // dp 저장 방식
        // dp[i][0]: i 마을이 우수 마을이 아닌 경우, dp[i][1]: 우수 마을인 경우 
        dp = new int[n + 1][2];

        String[] line = br.readLine().trim().split(" ");
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(line[i - 1]);
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            line = br.readLine().trim().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // DFS를 통해 DP 계산
        dfs(1);

        // 루트 노드(1번 마을)의 dp 값 중 최댓값 출력
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    // DFS를 사용한 DP 계산
    static void dfs(int index) {
        visited[index] = true;

        // 초기화: 우수 마을이 아닌 경우 dp[index][0] = 0, 우수 마을인 경우 dp[index][1] = population[index]
        dp[index][0] = 0;
        dp[index][1] = population[index];

        // 인접 노드에 대해 DFS 수행
        for (int next : adjList[index]) {
            if (!visited[next]) {
                dfs(next);
                
                // 인접 노드가 우수 마을이 아닌 케이스와 우수 마을인 케이스를 비교하여 DP 값 설정
                dp[index][0] += Math.max(dp[next][0], dp[next][1]);
                dp[index][1] += dp[next][0];
            }
        }
    }
}
