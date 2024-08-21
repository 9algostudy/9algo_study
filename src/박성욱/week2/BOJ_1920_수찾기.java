package 박성욱.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str[] = br.readLine().trim().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		int m = Integer.parseInt(br.readLine());
		int[] targetArr = new int[m];
		String str1[] = br.readLine().trim().split(" ");

		for (int i = 0; i < str1.length; i++) {
			targetArr[i] = Integer.parseInt(str1[i]);
		}
		
		Arrays.sort(arr);
//		Arrays.sort(targetArr);
		
		for(int i = 0;i<arr.length;i++) {
			int lt = 0;
			int rt = targetArr.length-1;
			int target = targetArr[i];
			
			boolean flag = false;
			while(lt<=rt) {
				int mid = (lt+rt) / 2;
				
				if (arr[mid]==target) {
					flag = true;
					break;
				}
				
				if(arr[mid]>target) {
					rt = mid -1;
				}
				else{
					lt = mid+1;
				}
				
			}
			
			System.out.println(flag ? 1 : 0);
		}
		
		
		
	}

}
