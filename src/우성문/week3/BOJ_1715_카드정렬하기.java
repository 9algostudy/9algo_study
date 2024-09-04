package 우성문.week3;

import java.io.*;
import java.util.*;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0;i<n;i++) {
			int card = Integer.parseInt(br.readLine().trim());
			queue.add(card);
		}
		long total = 0;
		while(queue.size()>1) {
			int card1 = queue.poll();
			int card2 = queue.poll();
			total += card1+card2;
			queue.add(card1+card2);
		}
		
		sb.append(total);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
