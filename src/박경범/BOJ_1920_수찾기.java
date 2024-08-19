package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int N = Integer.parseInt(br.readLine());	

		int[] arr1 = new int[N];

		input = br.readLine().split(" ");

		for(int i = 0; i < N; i++) {
			arr1[i]= Integer.parseInt(input[i]);
		}

		Arrays.sort(arr1);

		int M = Integer.parseInt(br.readLine());	

		input = br.readLine().split(" ");

		for(int i = 0; i < M; i++) {
			int targetNum = Integer.parseInt(input[i]);
			
			if(binarySearch(arr1, targetNum)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}


	}

	static boolean binarySearch(int[] arr1, int targetNum) {
		
		int min = 0;
		int max = arr1.length-1;

		while(min <= max) {
			int mid = (min + max) / 2;
			
			if(arr1[mid] == targetNum) {
				return true;
			} else if(arr1[mid] < targetNum) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		
		return false;
	}


}
