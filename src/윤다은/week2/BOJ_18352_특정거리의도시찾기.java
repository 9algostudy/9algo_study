package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {
	
	static int[][] connection;
	static int distance, cities;
	static int[] shortest;
	static StringBuilder sb;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		cities = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		connection = new int[cities][cities];
		shortest = new int[cities];
		
		while (roads-- > 0) {
			st = new StringTokenizer(br.readLine());
			connection[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		System.out.println(Arrays.deepToString(connection));
		
		stack.push(start-1);
		findCity(0, start);
		
		for (int i = 0; i < cities; i++) {
			if (shortest[i] == distance) {
				sb.append(i+1).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void findCity(int dist, int start) {
		if (dist == distance) {
			return;
		}
		
		for (int i = 0; i < cities; i++) {
			if (stack.contains(i)) continue;
			
			if (connection[start][i] == 1) {
				if (shortest[i] == 0) {
					shortest[i] = dist;
				}
				stack.push(i);
				findCity(dist+1, i);
				stack.pop();
			}
		}
	}
}
