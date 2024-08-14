package 박성욱.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		isPrime(n);
		
	}

	private static boolean isPrime(int n) {
		for(int i = 2;i<=n / 2 ;i++) {
			if(n %i ==0)
				return false;
		}
		return true;
	}
	
	
}
