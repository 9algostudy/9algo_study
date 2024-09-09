package 우성문.week5;

import java.io.*;
import java.util.*;

public class BOJ_11403_경로찾기 {
	static int n;
	static int[][] map;
	static int[][] answer;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_11403_경로찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		answer = new int[n][n];
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i = 0;i<n;i++) checkAnswer(i, new boolean[n]);
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}	
		
	}
	static void checkAnswer(int start, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int from = q.poll();
			for(int to = 0;to<n;to++) {
				if(from == to) continue;
				if(map[from][to]==1) {
					answer[start][to] = 1;
					if(!visited[to]) {
						visited[to] = true;
						q.add(to);
					}
				}
			}
		}
	}
}
