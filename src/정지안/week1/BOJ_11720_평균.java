package 정지안.week1;

import java.io.*;

public class BOJ_11720_평균 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String A = br.readLine();
        int sum =0;
        for(int i=0; i<n; i++){
            int num = A.charAt(i)-'0';
            sum += num;
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

}
