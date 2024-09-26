package 윤다은.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10844_쉬운계단수{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[12];
		Arrays.fill(nums, 1);
		nums[0] = 0; nums[1] = 0; nums[11] = 0;
		int[] tmp = new int[12];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < 11; j++) {
				tmp[j] = nums[j-1]+nums[j+1];
			}
			for (int j = 1; j < 11; j++) {
				nums[j] = tmp[j]%1000000000;
			}
		}
		
		double res = 0;
		for (int i = 1; i < 11; i++) {
			res += nums[i];
		}
		System.out.println((int)(res%1000000000));
	}
}
