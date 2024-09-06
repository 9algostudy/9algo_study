package 우성문.week4;

import java.util.*;
import java.io.*;

public class BOJ_5052_전화번호목록 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		ArrayList<String> phoneNums;
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			phoneNums = new ArrayList<>();
			for(int i= 0;i<n;i++) phoneNums.add(br.readLine().trim());
			Collections.sort(phoneNums);
			boolean flag = true;
			for(int i = 0;i<n-1;i++) {
				if(phoneNums.get(i).length()>phoneNums.get(i+1).length()) continue;
				if(phoneNums.get(i).equals(phoneNums.get(i+1).substring(0,phoneNums.get(i).length()))) {
					flag = false;
					break;
				}
			}
			sb.append(flag?"YES\n":"NO\n");
		}
		System.out.println(sb.toString());
	}
}
