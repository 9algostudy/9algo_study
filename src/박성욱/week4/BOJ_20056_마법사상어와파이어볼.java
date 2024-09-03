package 박성욱.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20056_마법사상어와파이어볼 {

	static int r, c, m, s, d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().trim().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);

		int[][] arr = new int[N][N];
		int[][] ballcnt = new int[N][N];
		int[][] ballspd = new int[N][N];
		int[][] balldir = new int[N][N];
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < M; i++) {
			String strarr[] = br.readLine().trim().split(" ");

			int r = Integer.parseInt(strarr[0]);
			int c = Integer.parseInt(strarr[1]);
			int m = Integer.parseInt(strarr[2]);
			int s = Integer.parseInt(strarr[3]);
			int d = Integer.parseInt(strarr[4]);

			int newrow = (r + dr[d] * s) % N;
			int newcol = (c + dc[d] * s) % N;

			
			arr[newrow][newcol] += m;

			if (arr[newrow][newcol] != 0) {
				arr[newrow][newcol] += m;
				ballcnt[newrow][newcol] += 1;
				ballspd[newrow][newcol] += s;
				balldir[newrow][newcol] += d;
			}
		}

		for (int y = 0; y < K; y++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ballcnt[i][j] != 0) {
						
							int s = ballspd[i][j] / (ballcnt[i][j]);
							int m = arr[i][j] / 5;
//							int d = balldir[i][j];
							
	                        if (m > 0) {
	                            boolean allEven = true;
	                            boolean allOdd = true;

	                            for (int dIndex = 0; dIndex < ballcnt[i][j]; dIndex++) {
	                                int direction = balldir[i][j]; 
	                                if (direction % 2 == 0) {
	                                    allOdd = false;
	                                } else {
	                                    allEven = false;
	                                }
	                            }

							
                            for (int x = 0; x < 4; x++) {
							if ((allEven||allOdd)) {
								int newdr[] = { -1, 0, 1, 0 };
								int newdc[] = { 0, 1, 0, -1 };
								
								int newrow = (i + newdr[x] * s) % N;
								int newcol = (j + newdc[x] * s) % N; 

								arr[newrow][newcol] += m;
							
							} else {
								int newdr[] = { 1, -1, -1, 1 };
								int newdc[] = { 1, 1, -1, -1 };
								
								int newrow = (i + newdr[x] * s) % N;
								int newcol = (j + newdc[x] * s) % N;
								
								arr[newrow][newcol] += m;
							}
						}
					}
				}
			}
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res += arr[i][j];

			}
		}

		System.out.println(res);
	}

}
}
