package 윤다은.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2252_줄세우기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] indegree = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int front, back;
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			front = Integer.parseInt(s[0]);
			back = Integer.parseInt(s[1]);
			
			indegree[back]++;
			list[front].add(back);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");
			
			for (int i = 0; i < list[n].size(); i++) {
				int tmp = list[n].get(i);
				indegree[tmp]--;
				if (indegree[tmp] == 0) queue.offer(tmp);
			}
		}
		
	}
}
