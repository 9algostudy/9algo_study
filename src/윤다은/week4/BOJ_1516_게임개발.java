package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N+1];
		int[] res = new int[N+1];
		int[] degree = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			res[i] = time[i];
			
			int n;
			while ((n=Integer.parseInt(st.nextToken())) != -1) {
				degree[i]++;
				list[n].add(i);
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 0; i < list[n].size(); i++) {
				int tmp = list[n].get(i);
				res[tmp] = Math.max(res[tmp], res[n] + time[tmp]);
				degree[tmp]--;
				
				if (degree[tmp] == 0) queue.add(tmp);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
	}
}
