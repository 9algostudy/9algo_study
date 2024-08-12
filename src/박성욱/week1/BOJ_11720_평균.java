package 박성욱.week1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		String str [] = br.readLine().trim().split("");
		int arr [] = new int [str.length];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += Integer.parseInt(str[i]);
		}
		
		System.out.println(sum);
		
		
	
	}
}

