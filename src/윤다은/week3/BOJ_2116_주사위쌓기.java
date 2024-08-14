package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] nums = new int[6];
		int[] sum = new int[6];
		int[] order = {0, 1, 2, 4, 5, 3};
		int[] pre = new int[6];
		
		int x, y;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 6; j++) {
			nums[order[j]] = Integer.parseInt(br.readLine());
		}
		
		for (int j = 0; j < 3; j++) {
			
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			
		}
	}
}
