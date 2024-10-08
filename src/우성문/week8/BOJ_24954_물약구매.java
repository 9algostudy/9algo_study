package 우성문.week8;

import java.io.*;

public class BOJ_24954_물약구매 {
	static int n,min = Integer.MAX_VALUE;
	static int[] potion;
	static int[][][] saleList;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week8/BOJ_24954_물약구매.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		n = Integer.parseInt(br.readLine());
		potion = new int[n+1];
		saleList = new int[n+1][n+1][2];
		line = br.readLine().split(" ");
		for(int i =0;i<n;i++) potion[i+1] = Integer.parseInt(line[i]);
		for(int i = 1;i<=n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>0) {
				for(int j=0;j<x;j++) {
					line = br.readLine().split(" ");
					saleList[i][j][0] = Integer.parseInt(line[0]);
					saleList[i][j][1] = Integer.parseInt(line[1]);
				}
			}
		}
		dfs(0,new int[n],new boolean[n+1]);
		System.out.println(min);
	}
	static void dfs(int idx, int[] set, boolean[] visited) {
		if(idx==n) {
			check(set);
			return;
		}
		for(int i = 1;i<=n;i++) {
			if(visited[i]) continue;
			set[idx] = i;
			visited[i] = true;
			dfs(idx+1,set,visited);
			visited[i] = false;
		}
	}
	
	static void check(int[] set) {
		int total = 0;
		int[] temp = potion.clone();
		for(int i=0;i<n;i++) {
			int idx = set[i];
			total+=temp[idx];
			for (int j = 0; j < n; j++) {
				if(saleList[idx][j][0]==0) continue;
				temp[saleList[idx][j][0]] -= saleList[idx][j][1];
				if (temp[saleList[idx][j][0]] < 1)
					temp[saleList[idx][j][0]] = 1;
			}
		}
		min = Math.min(min, total);
	}
}
