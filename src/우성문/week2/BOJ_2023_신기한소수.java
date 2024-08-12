package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_2023_신기한소수 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder(1000);

		int n = Integer.parseInt(br.readLine().trim());

		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);

		for (int i = 1; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int idx = 0; idx < list.size(); idx++) {
				for (int j = 1; j < 9; j+=2) {
					int num = list.get(idx)*10+j;
					if(checkPrime(num)) {
						temp.add(num);
					}
				}
			}
			list.clear();
			list.addAll(temp);
		}
		Collections.sort(list);
		for(Integer num : list) {
			sb.append(num).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static boolean checkPrime(int num) {
		for(int i = 3;i<num/2;i+=2) {
			if(num%i==0)
				return false;
		}
		return true;
	}
}
