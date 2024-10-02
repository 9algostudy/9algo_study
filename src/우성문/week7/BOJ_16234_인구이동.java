package 우성문.week7;

import java.io.*;
import java.util.*;

public class BOJ_16234_인구이동 {
	static int  n,l,r,day=0;
	static int[][] map, check;
	static ArrayList<int[]>[] list;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week7/BOJ_16234_인구이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		n = Integer.parseInt(line[0]);
		l = Integer.parseInt(line[1]);
		r = Integer.parseInt(line[2]);
		map = new int[n][n];
		list = new ArrayList[n*n+1];
		
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		while(true) {
			Stack<Integer> stack = new Stack<>();
			check = new int[n][n];
			int cnt = 0;
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(check[i][j]==0) {
						check[i][j] = ++cnt;
						list[cnt] = new ArrayList<>();
						Queue<int[]> q = new LinkedList<>();
						list[cnt].add(new int[] {i,j});
						q.offer(new int[] {i,j});
						while(!q.isEmpty()) {
							int[] current = q.poll();
							for(int idx = 0;idx<4;idx++) {
								int x = current[0]+dx[idx];
								int y = current[1]+dy[idx];
								if(isBound(x, y)&&check[x][y]==0) {
									int abs =Math.abs(map[x][y]-map[current[0]][current[1]]);
									if(abs>=l&&abs<=r) {
										check[x][y] = cnt;
										list[cnt].add(new int[] {x,y});
										q.offer(new int[] {x,y});
									}
								}
							}
						}
						if(list[cnt].size()>1) {
							stack.add(cnt);
						}
					}
				}
			}
			if(stack.isEmpty()) break;
			day++;
			
			while(!stack.isEmpty()) {
				int num = stack.pop();
				int areaCnt = list[num].size();
				int total = 0;
				for(int[] area : list[num]) {
					total += map[area[0]][area[1]];
				}
				for(int[] area : list[num]) {
					map[area[0]][area[1]] = total/areaCnt;
				}
			}
		}
		System.out.println(day);
	}
	
	static boolean isBound(int x,int y) {
		return !(x<0||x>=n||y<0||y>=n);
	}
}
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        return answer;
    }
}