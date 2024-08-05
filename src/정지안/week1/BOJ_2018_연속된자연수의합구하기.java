package 정지안.week1;

import java.io.*;

public class BOJ_2018_연속된자연수의합구하기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int lt = 1;
        int rt = 1;
        int sum = 1;
        while (lt <= rt) {
            if (sum == n) {
                cnt++;
                sum -= lt;
                lt++;
            } else if (sum < n) {
                rt++;
                sum += rt;
            } else if (sum > n) {
                sum -= lt;
                lt++;
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

