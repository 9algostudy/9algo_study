package 우성문.week5;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달 {
	static int n, m;
	static int[][] map;
	static ArrayList<House> houses; 
	static ArrayList<House> chicken;
	static int[] minDist;
	static int min;
	
	static class House{
		int x;
		int y;
		
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "House [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_15686_치킨배달.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			line = br.readLine().trim().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			houses = new ArrayList<>();
			chicken = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				line = br.readLine().trim().split(" ");
				for(int j=0;j<n;j++) {
//					map[i][j] = Integer.parseInt(line[j]);
					int num = Integer.parseInt(line[j]);
					if(num==1) {
						houses.add(new House(i, j));
					}else if(num==2) {
						chicken.add(new House(i, j));
					}
				}
			}
			min = Integer.MAX_VALUE;
			minDist = new int[houses.size()];
			checkTotalDist(0,0,new House[m]);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void checkTotalDist(int idx,int start,House[] list) {
		if(idx == m) {
			Arrays.fill(minDist, Integer.MAX_VALUE);
			for(House chicken : list) {
				for(int i =0;i<houses.size();i++) {
					int dist = Math.abs(chicken.x-houses.get(i).x)+Math.abs(chicken.y-houses.get(i).y);
					minDist[i] = Math.min(minDist[i], dist);
				}
			}
			int total = 0;
			for(int i =0;i<houses.size();i++) total+=minDist[i];
			min = Math.min(min, total);
			return;
		}
		for(int i = start;i<chicken.size();i++) {
			list[idx] = chicken.get(i);
			checkTotalDist(idx+1, i+1, list);
		}
	}
}
