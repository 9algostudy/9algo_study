package 우성문.week1;

import java.io.*;

public class BOJ_1546_평균구하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tc = br.readLine().trim();
		String[] line = br.readLine().trim().split(" ");
		
		double total = 0;
		int max = 0;
		for(int i = 0;i<line.length;i++) {
			int num = Integer.parseInt(line[i]);
			total+=num;
			max = Math.max(max, num);
		}
		
		total *= (100.0/max);
		
		System.out.println(total/line.length);
	}
}
