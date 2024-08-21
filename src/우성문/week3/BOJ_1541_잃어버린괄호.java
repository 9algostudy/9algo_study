package 우성문.week3;

import java.io.*;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine().trim();
		int total = 0;
		if(str.contains("-")) {
			String[] line = str.split("-");
			if(line[0].contains("+")) {
				String[] nums = line[0].split("\\+");
				for(int i = 0;i<nums.length;i++) {
					total += Integer.parseInt(nums[i]);
				}
			}else {
				total += Integer.parseInt(line[0]);
			}
			
			for(int i = 1;i<line.length;i++) {
				if(line[i].contains("+")) {
					String[] nums = line[i].split("\\+");
					for(int j = 0;j<nums.length;j++) {
						total -= Integer.parseInt(nums[j]);
					}
				}else {
					total -= Integer.parseInt(line[i]);
				}
			}
		}else {
			if(str.contains("+")) {
				String[] nums = str.split("\\+");
				for(int i = 0;i<nums.length;i++) {
					total += Integer.parseInt(nums[i]);
				}
			}else {
				total += Integer.parseInt(str);
			}
		}
		
		sb.append(total);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
