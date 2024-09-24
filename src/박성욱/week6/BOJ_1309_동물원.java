package 박성욱.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1309_동물원{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(3);
			return;
		}
		else if(n==2){
			System.out.println(7);
			return;
		}
		
		int d [] = new int [n+1];
		
		d[1] = 3;
		d[2] = 7;
		
		for(int i = 3;i<n+1;i++) {
			d[i] = (d[i-1] * 2 + d[i-2]) % 9901;
		}
		System.out.println(d[n]);
		
	}
}
