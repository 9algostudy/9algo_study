package 우성문.week1;

import java.io.*;

public class BOJ_11660_구간합구하기2 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder(1000);
		
		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int[][] sum = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=1;j<=n;j++) {
				sum[i][j] = sum[i][j-1] + Integer.parseInt(line[j-1]);
			}
		}
		
		for(int i=0;i<m;i++) {
			line = br.readLine().trim().split(" ");
			int startRow = Integer.parseInt(line[0]);
			int startCol= Integer.parseInt(line[1]);
			int endRow = Integer.parseInt(line[2]);
			int endCol = Integer.parseInt(line[3]);
			
			long total = 0;
			
			for(int r = startRow;r<=endRow;r++) {
				total += sum[r][endCol] -sum[r][startCol-1]; 
			}
			sb.append(total);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
