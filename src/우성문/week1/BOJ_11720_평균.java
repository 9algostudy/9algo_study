package 우성문.week1;

import java.io.*;

public class BOJ_11720_평균 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine().trim();
		line = br.readLine().trim().replace("0", "");
		String[] arr = line.split("");
		
		int total = 0 ;
		for(String s : arr) {
			total += Integer.parseInt(s); 
		}
		
		sb.append(total);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
