package 정지안.week3;

import java.io.*;
import java.util.StringTokenizer;

// =========== 문제 접근 ===========
// 오름차순으로정렬된 배열의 역순으로 접근하며 뺄 수 있는만큼 뺀다.
public class BOJ_11047_동전0 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr =new int[n];
        for(int i=0; i<n; i++) {
            int moneyUnit = Integer.parseInt(br.readLine());
            arr[i] = moneyUnit;
        }


        int cnt = 0;

        for(int i=n-1; i>=0; i--){//오름차순의 역순으로 조회
            while(arr[i] <= k){
                cnt++;
                k-=arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}
