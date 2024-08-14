package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		p += t;
		q += t;
		
		int a = p/w;
		p %= w;
		if (a % 2 == 1) {
			p = w-p;
		}
		
		a = q/h;
		q %= h;
		if (a%2 == 1) {
			q = h-q;
		}
		
		System.out.println(p + " " + q);
	}
}
