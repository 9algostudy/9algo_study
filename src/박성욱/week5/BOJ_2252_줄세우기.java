package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2252_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nmarr = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmarr[0]);
		int m = Integer.parseInt(nmarr[1]);
		
		ArrayList<Integer> [] arr = new ArrayList[n+1];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = new ArrayList<>();
		}
		int degree[] = new int [n+1];
		
		for(int i = 0;i<m;i++) {
			String [] abarr = br.readLine().trim().split(" ");
			int a = Integer.parseInt(abarr[0]);
			int b = Integer.parseInt(abarr[1]);
			arr[a].add(b);
			degree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		//차수가 0이면 큐에 넣기
		for(int i = 1; i<=n;i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			// 큐에서 뽑기
			int now = q.poll();
			//뽑은 차수의 원소
			System.out.print(now+ " ");
			for(int x : arr[now] ) {
				degree[x]--;
				if(degree[x] == 0) {
					q.add(x);
				}
			}
		}
		
		
	}
}
