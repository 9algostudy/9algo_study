package 우성문.week1;

import java.io.*;
import java.util.*;

public class BOJ_11286_절댓값힙구현하기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> keySet = new PriorityQueue<>();
		HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			if(num==0) {
				if(map.isEmpty()) {
					sb.append("0\n");
				}else {
					int minValue = keySet.peek();
					PriorityQueue<Integer> pQ = map.get(minValue);
					sb.append(pQ.poll());
					sb.append("\n");
					if(pQ.isEmpty()) {
						map.remove(minValue);
						keySet.remove(minValue);
					}
				}
			}else {
				int abs = Math.abs(num);
				PriorityQueue<Integer> values;
				if(!map.containsKey(abs)) {
					keySet.add(abs);
					values = new PriorityQueue<>();
				}else {
					values = map.get(abs);
				}
				values.add(num);
				map.put(abs, values);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
