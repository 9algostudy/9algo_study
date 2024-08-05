package 정지안.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// ================ 문제 접근 ================
// 문제 요구사항 : 두 개의 원소를 합쳐서 sum이되는 개수 카운팅
// 고유한 번호가 주어지므로, 2중 for문을 돌면서 dp로 합의인덱스를 ++ 시키는 방식으로 해결해도 되겠는데?
public class BOJ_1940_주몽의명령 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[m+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr[i]+arr[j];
                if(sum>m) continue;

                dp[sum]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[m]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }
}
