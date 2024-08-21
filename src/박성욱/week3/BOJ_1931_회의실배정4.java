package 박성욱.week3;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class BOJ_1931_회의실배정4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [][] = new int [n][2];
		for(int i = 0;i<n;i++) {
			String str [] = br.readLine().trim().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		

		Arrays.sort(arr,new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				//만약 뒤의 종료시간이 같다면
				//앞의 시간이 더 빠른시간을 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				//
				return o1[1]-o2[1];
			}
		});
		
//		System.out.println(Arrays.deepToString(arr));

		
		int cnt = 0;
		int end = -1;
		
		for(int i = 0;i<n;i++) {
			if(arr[i][0]>=end) {
				end = arr[i][1];
//				System.out.println(end);
				
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
