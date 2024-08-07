package 우성문.week1;

import java.io.*;

public class BOJ_11659_구간합구하기 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		long[] sum = new long[n+1];
		line = br.readLine().trim().split(" ");
		for(int i =1;i<=n;i++) {
			sum[i] = Integer.parseInt(line[i-1])+sum[i-1];
		}
		
		for(int i =0;i<m;i++){
			line = br.readLine().trim().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			System.out.println(sum[y]-sum[x-1]);
		}
	}
}
