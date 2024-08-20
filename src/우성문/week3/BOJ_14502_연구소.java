package 우성문.week3;

import java.util.*;
import java.io.*;

public class BOJ_14502_연구소 {
	static int[][] map;
	static int n;
	static int m;
	static ArrayList<int[]> virusCoordiante = new ArrayList<>();
	static ArrayList<int[]> virusInfo = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().trim().split(" ");
		
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];

		int safeArea = 0;
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j]==0) {
					safeArea++;
				}else if(map[i][j]==2) {
					virusCoordiante.add(new int[] {i,j});
				}
			}
		}
		
		
	}
	
	static boolean isBound(int x,int y) {
		if(x<0||x>=n||y<0||y>=m)
			return false;
		return true;
	}
	
}
