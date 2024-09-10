package 윤다은.week5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int cSize, hSize, min, M;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static Point[] choose;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		choose = new Point[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) house.add(new Point(i, j));
				else if (n == 2) chicken.add(new Point(i, j));
			}
		}
		
		cSize = chicken.size();
		hSize = house.size();
		
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int depth, int n) {
		if (depth == M) {
			dist = new int[hSize];
			
			for (int i = 0; i < hSize; i++) {
				dist[i] = Math.abs(choose[0].x-house.get(i).x) + Math.abs(choose[0].y-house.get(i).y);
			}

			int res = 0;
			for (int i = 0; i < hSize; i++) {
				for (int j = 1; j < M; j++) {
					dist[i] = Math.min(dist[i], Math.abs(choose[j].x-house.get(i).x) + Math.abs(choose[j].y-house.get(i).y));
				}
				res += dist[i];
			}
			
			min = Math.min(min, res);
			
			return;
		}
		
		int size = cSize-M+depth+1;
		for (int i = n; i < size; i++) {
			choose[depth] = chicken.get(i);
			dfs(depth+1, i+1);
		}
	}
}
