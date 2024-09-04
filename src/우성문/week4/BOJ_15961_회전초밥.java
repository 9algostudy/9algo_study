package 우성문.week4;

import java.util.*;
import java.io.*;

public class BOJ_15961_회전초밥 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int d = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);
		int c = Integer.parseInt(line[3]);
		int max = 0;
		int[] sushi = new int[n];
		HashMap<Integer,Integer> set = new HashMap<>();
		for(int i = 0;i<n+k;i++) {
			if(i<n) {
				sushi[i] = Integer.parseInt(br.readLine().trim());
			}
			if(i<k-1) {
				int cnt = set.getOrDefault(sushi[i], 0);
				set.put(sushi[i], cnt+1);
			}else if(i==k-1){
				int cnt = set.getOrDefault(sushi[i], 0);
				set.put(sushi[i], cnt+1);
				int caseCnt = set.size() + (set.containsKey(c)?0:1);
				max = Math.max(max, caseCnt);
			}else {
				int cnt = set.getOrDefault(sushi[i%n], 0);
				set.put(sushi[i%n], cnt+1);
				int prev = sushi[(i-k)%n];
				int temp = set.get(prev);
				if(temp== 1) {
					set.remove(prev);
				}else {
					set.put(prev, temp-1);
				}
				int caseCnt = set.size() + (set.containsKey(c)?0:1);
				max = Math.max(max, caseCnt);
			}
		}
		System.out.println(max);
	}
}
