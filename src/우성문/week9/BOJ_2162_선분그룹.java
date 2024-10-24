package 우성문.week9;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import 우성문.week9.BOJ_1197_최소스패닝트리.Edge;

public class BOJ_2162_선분그룹 {
	static int n;
	static Line[] list;
	static int[] parent;
	static int[] rank;
	
	static class Line{
		int[] start;
		int[] end;
		Double gradient;
		public Line(int[] start, int[] end) {
			this.start = start;
			this.end = end;
			int dx = start[0]-end[0];
			int dy = start[1]-end[1];
			if(dx==0) {
				gradient = null;
			}else {
				gradient = dy/(dx*1.0);
			}
		}
		
		public int positionCheak(int x,int y) {
			double value;
			if(gradient !=null) {
				value = gradient*(x-start[0]) + start[1];
				if(y==value) {
					return 0;
				}else if(y>value) {
					return 1;
				}else {
					return -1;
				}
			}else {
				if(start[0]==x) {
					return 0;
				}else if(start[0]>x) {
					return 1;
				}else {
					return -1;
				}
			}
		}
		
		public boolean checkGradient(Line temp) {
			int dx = start[0]-end[0];
			int dy = start[1]-end[1];
			int tempDx = temp.start[0]-temp.end[0];
			int tempDy = temp.start[1]-temp.end[1];
			
			boolean flag1 = (start[0]-temp.end[0])*(temp.start[0]-end[0])>0;
			boolean flag2 = (start[1]-temp.end[1])*(temp.start[1]-end[1])>0;
			
			if (flag1&&flag2) {
				if(Double.compare(gradient, temp.gradient)==0) return true;
//				if(dx==tempDx&&dy==tempDy) return true;
//				if(dx==-tempDx&&dy==-tempDy)return true;
			}
			return false;
		}
		
	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week9/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a;
		n = Integer.parseInt(br.readLine());
		list = new Line[n+1];
		parent = new int[n+1];
		for(int i =1;i<n+1;i++) parent[i] = i;
		rank = new int[n+1];
		for(int i =1;i<n+1;i++) {
			a = br.readLine().split(" ");
			int[] start = {Integer.parseInt(a[0]),Integer.parseInt(a[1])};
			int[] end = {Integer.parseInt(a[2]),Integer.parseInt(a[3])};
			list[i] = new Line(start, end);
		}
		for(int i =1;i<n;i++) {
			for(int j=i+1;j<n+1;j++) {
				if(find(i)==find(j)) continue;
				if(list[i].checkGradient(list[j])) continue;
				boolean flag1 = list[i].positionCheak(list[j].start[0], list[j].start[1])*list[i].positionCheak(list[j].end[0], list[j].end[1]) <= 0;
				boolean flag2 = list[j].positionCheak(list[i].start[0], list[i].start[1])*list[j].positionCheak(list[i].end[0], list[i].end[1]) <= 0;
				if(flag1&&flag2) {
//					System.out.println(list[i].gradient);
//					System.out.println(list[j].gradient);
					union(i, j);
				}
			}
		}
		int[] lineCnt = new int[n+1];
		for(int i = 1;i<=n;i++) {
			lineCnt[find(i)]++;
		}
		int answer = 0;
		int max = 1;
		for(int i = 1;i<=n;i++) {
			if(lineCnt[i]>0) answer++;
			max = Math.max(max, lineCnt[i]);
		}
		
		System.out.println(answer);
		System.out.println(max);
	}

}
