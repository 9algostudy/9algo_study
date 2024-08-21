package 박성욱.week1;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.Scanner;

	public class BOJ_11659_구간합구하기 {
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String [] nmArr = br.readLine().trim().split(" ");
			int n = Integer.parseInt(nmArr[0]);
			int m = Integer.parseInt(nmArr[1]);
			
			String [] strArr = br.readLine().trim().split(" ");
			int [] arr = new int[strArr.length];
			for ( int i = 0;i<n;i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}
			
			int [] sumArr = new int [arr.length];
			sumArr[0] = arr[0];
			for(int i = 0;i<arr.length-1;i++) {
				sumArr[i+1] = sumArr[i] + arr[i+1];
			}
			
			for(int i =0;i<m;i++	) {
				String [] str1 = br.readLine().trim().split(" ");
				int fir = Integer.parseInt(str1[0]);
				int sec = Integer.parseInt(str1[1]);
				
				int res = 0;
	            if (fir == 1) {
	                res = sumArr[sec - 1];
	            } else {
	                res = sumArr[sec - 1] - sumArr[fir - 2];
	            }
				
				System.out.println(res);
			}
			
		}
	}

