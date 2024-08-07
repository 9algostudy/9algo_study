package 정지안.week1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int[][] rowSum = new int[n+1][n+1];

        //배열초기화
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 열의 누적합 초기화하기
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                rowSum[i][j] = rowSum[i][j-1] + arr[i-1][j-1];
            }
        }

        //출력하기
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int fromY = Integer.parseInt(st.nextToken());
            int fromX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int y = fromY; y<=toY; y++){
                sum += rowSum[y][toX] - rowSum[y][fromX-1];
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();






    }
}
