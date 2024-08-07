package 정지안.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1546_평균구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = -10000;
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max,num);
        }

        double sum = 0;
        for(int x : arr){
            sum += (double)x/max*100;
        }
        bw.write(sum/n+"\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
