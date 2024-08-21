package 우성문.week3;

import java.util.*;
import java.io.*;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());
		int[] result = new int[n];
		
		String[] line = br.readLine().trim().split(" ");
		Stack<Integer> top = new Stack<>();
		Stack<Integer> idx = new Stack<>();


		for (int i = n - 1; i >= 0; i--) {
			int height= Integer.parseInt(line[i]);
			int size = 1;
			while(!top.isEmpty()&&top.peek()<height) {
				result[idx.pop()] = i+1;
				top.pop();
			}
			top.push(height);
			idx.push(i);
		}
		for(int i = 0;i<n;i++) {
			sb.append(result[i]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}