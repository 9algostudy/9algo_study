package 우성문.week8;

import java.io.*;
import java.util.Arrays;

public class BOJ_3020_개똥벌레 {
	static int n,h;
	static int[] stalagmite,stalactite;// 종유석, 석순
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week8/BOJ_3020_개똥벌레.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		h = Integer.parseInt(a[1]);
		stalagmite = new int[h+1];
		stalactite = new int[h+1];
		for(int i = 0;i<n;i++) { 
			int num = Integer.parseInt(br.readLine());
			if(i%2==0) {
				stalagmite[num]++;
			}else {
				stalactite[num]++;
			}
		}
		for(int i = h;i>1;i--) {
			stalagmite[i-1] += stalagmite[i];
			stalactite[i-1] += stalactite[i];
		}
		for(int i = 1;i<=h;i++) {
			stalagmite[i] += stalactite[h-i+1];
		}
		
		Arrays.sort(stalagmite);
		int cnt = 0;
		for(int i = 1;i<=h;i++) {
			if(stalagmite[1]==stalagmite[i]) cnt++;
			else break;
		}
		System.out.println(stalagmite[1]+" "+cnt);
	}
}
