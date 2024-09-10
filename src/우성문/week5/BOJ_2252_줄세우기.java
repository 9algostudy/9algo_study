package 우성문.week5;

import java.io.*;
import java.util.*;

public class BOJ_2252_줄세우기 {
	static int n,m;
	static int[] degree;
	static HashSet<Integer>[] list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_2252_줄세우기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		list = new HashSet[n+1];
		degree = new int[n+1];
		
		for(int i = 0;i<m;i++) {
			line = br.readLine().trim().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			if(list[from]==null) {
				list[from] = new HashSet<>();
			}
			list[from].add(to);
			degree[to]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			if(degree[i]==0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current + " ");
			if(list[current]!=null) {
				for(Integer x : list[current]) {
					degree[x]--;
					if(degree[x]==0) {
						q.add(x);
					}
				}
			}
		}
	}
}
