package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] first = {2, 3, 5, 7};
		
		for (int n : first) {
			dfs(n, 1);
		}
	}
	
	static void dfs(int num, int depth) {
		if (depth == N) {
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i <= 9; i+=2) {
			if (isPrime(num*10 + i)) {
				dfs(num*10+i, depth+1);
			}
		}
	}
	
	static boolean isPrime(int num) {
		int until = num/2;
		
		for (int i = 3; i < until; i+=2) {
			if (num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
