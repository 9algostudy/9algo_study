package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1309_동물원{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] zoo = new int[3];
		Arrays.fill(zoo, 1);
		
		int a, b, c;
		for (int i = 1; i < N; i++) {
			a = zoo[0]+zoo[1]+zoo[2];
			b = zoo[0]+zoo[2];
			c = zoo[0]+zoo[1];
			zoo[0] = a%9901;
			zoo[1] = b%9901;
			zoo[2] = c%9901;
		}
		
		int res = (zoo[0]+zoo[1]+zoo[2])%9901;
		System.out.println(res);
	}
}
