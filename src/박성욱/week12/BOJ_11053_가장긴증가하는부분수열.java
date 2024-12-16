package 박성욱.week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://loosie.tistory.com/376
public class BOJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().trim().split(" ");
        
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        
        int len = 1;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            len = Math.max(len, dp[i]);
        }
        
        System.out.println(len);
    }
}