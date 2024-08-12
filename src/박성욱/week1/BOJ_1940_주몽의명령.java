package 박성욱.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1940_주몽의명령 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String [] str = br.readLine().trim().split(" ");
		int [] arr = new int [str.length];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int cnt = 0;
		for(int i = 0;i<arr.length;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i]+arr[j] == m	) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
	}
}

