package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11660_구간합구하기5  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

		int[][] arr = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		
		
		// 배열에 값 채워 넣기 -> 표 생성
		for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(line[j-1]);
			}
		}

        // 2차원 누적 합 배열 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
				// System.out.println("sum[" + i + "][" +j + "] = " + sum[i][j]);
            }
        }
		
		// M개의 쿼리 처리
		for (int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            
            int x1 = Integer.parseInt(query[0]);
            int y1 = Integer.parseInt(query[1]);
            
            int x2 = Integer.parseInt(query[2]);
            int y2 = Integer.parseInt(query[3]);
			
			int result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
			System.out.println(result);
		}
	}
}
