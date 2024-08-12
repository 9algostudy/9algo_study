package 박성욱.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class BOJ_2018_연속된자연수의합구하기{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = 1;
		int end = 1;
		int sum = 1; 
		int cnt = 1;
		while (end != N){
			if (sum == N){
				cnt++; 
				end++;
				sum = sum+end;
			}else if(sum >N) {
				sum = sum-start;  
				start++;
			}else if(sum <N) {
				end++;
				sum = sum+end;
			}
			
		}
		System.out.println(cnt);
	}
}