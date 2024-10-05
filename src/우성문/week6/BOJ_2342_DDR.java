package 우성문.week6;

import java.io.*;
import java.util.Arrays;

public class BOJ_2342_DDR{
	static int n,left, right;
	static int[] nums;
	static int[][] moveEnergy= {{},{0,1,3,4,3},{0,3,1,3,4},{0,4,3,1,3},{0,3,4,3,1}};
	static Position[][] dp;
	
	static class Position implements Comparable<Position>{
		int left;
		int right;
		int usePower;
		
		public Position(int left, int right, int usePower) {
			this.left = left;
			this.right = right;
			this.usePower = usePower;
		}

		@Override
		public int compareTo(Position o) {
			return Integer.compare(usePower, o.usePower);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week6/BOJ_2342_DDR.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line;
		for(int tc = 1;tc<=20;tc++) {
			line = br.readLine().trim().split(" ");
			int real = Integer.parseInt(br.readLine().trim());
			n = line.length-1;
			if(n==0) {
				System.out.println(0);
			}else {
				nums = new int[n];
				dp = new Position[n][5];
				for(int i = 0;i<n;i++) nums[i] = Integer.parseInt(line[i]);
				left = nums[0];
				int value = 2;
				int idx = 1;
				dp[0][left] = new Position(left, 0, value);
				while(left==nums[idx]) {
					value++;
					dp[idx++][left] = new Position(left, 0, value);
				}
				right = nums[idx];
				value +=2 ;
				dp[idx++][left] = new Position(left, right, value);
				for(int i = idx;i<n;i++) {
					for(int j=1;j<5;j++) {
						if(dp[idx-1][j]==null) continue;
//						dp[idx][nums[idx]]
					}
				}
				
			}
		}
	}
}
