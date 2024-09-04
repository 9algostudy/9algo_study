package 박성욱.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_18352_특정거리의도시찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		int x = Integer.parseInt(str[3]);
		
		List<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i = 0;i<n+1;i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i = 0;i<m;i++) {
			String [] str1 = br.readLine().trim().split(" ");
			int a = Integer.parseInt(str1[0]);
			int b = Integer.parseInt(str1[1]);
			arr.get(a).add(b);
		}
		
		int dist [] = new int [n+1];
		for(int i = 0;i<dist.length;i++) {
			dist[i] = Integer.MIN_VALUE;
		}
		
		dist[x] = 0;
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(x);
		while(!q.isEmpty()) {
			int now=q.poll();
			
			for(int i=0;i<arr.get(now).size();i++) {
				int next=arr.get(now).get(i);
				if(dist[next]==Integer.MIN_VALUE) {
					dist[next]=dist[now]+1;
					q.offer(next);
				}
			}
		}
		
		boolean flag=false;
		for(int i=1;i<=n;i++) {
			if(dist[i]==k) {
				System.out.println(i);
				flag=true;
			}
		}
		
		if(!flag)
			System.out.println(-1);

		
	}
}
