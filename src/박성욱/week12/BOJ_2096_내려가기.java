package 박성욱.week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2096_내려가기{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr [][] = new int [n][3];
		for(int i = 0;i<n;i++) {
			String str [] = br.readLine().trim().split(" ");
			for(int j = 0;j<3;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int mindp[][] = new int [n][3];
		int maxdp[][] = new int [n][3];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ;i<3;i++) {
			mindp[0][i] = arr[0][i];
			maxdp[0][i] = arr[0][i];
		}
		
        for (int i = 1; i < n; i++) {
            maxdp[i][0] = Math.max(maxdp[i-1][0], maxdp[i-1][1]) + arr[i][0];
            maxdp[i][1] = Math.max(Math.max(maxdp[i-1][0], maxdp[i-1][1]), maxdp[i-1][2]) + arr[i][1];
            maxdp[i][2] = Math.max(maxdp[i-1][1], maxdp[i-1][2]) + arr[i][2];
            
            mindp[i][0] = Math.min(mindp[i-1][0], mindp[i-1][1]) + arr[i][0];
            mindp[i][1] = Math.min(Math.min(mindp[i-1][0], mindp[i-1][1]), mindp[i-1][2]) + arr[i][1];
            mindp[i][2] = Math.min(mindp[i-1][1], mindp[i-1][2]) + arr[i][2];
        }
		
		for(int i = 0;i<3;i++) {
			min = Math.min(min,mindp[n-1][i]);
			max = Math.max(max,maxdp[n-1][i]);
		}
		System.out.println(max +" " + min);
	}

}
