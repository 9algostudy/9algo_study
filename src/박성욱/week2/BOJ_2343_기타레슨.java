package 박성욱.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import 박성욱.Main;

public class BOJ_2343_기타레슨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nmarr [] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmarr[0]);
		int m = Integer.parseInt(nmarr[1]);
		
		int arr [] = new int [n];
		
		int maxlen = 0;
		int total = 0;
		String str [] = br.readLine().trim().split(" ");
		for (int i = 0;i<str.length;i++) {
			arr[i] = Integer.parseInt(str[i]);
			if(maxlen<arr[i]) {
				maxlen = arr[i];
			}
			total += maxlen;
		}
		
		int lt = maxlen;
		int rt = total;
		
		
		   while (lt <= rt) {
	            int mid = (lt + rt) / 2;
	            int cnt = 1;  
	            int sum = 0;
	            for (int i = 0; i < n; i++) {
	                if (sum + arr[i] > mid) {
	                    cnt++;
	                    sum = arr[i];
	                } else {
	                    sum += arr[i];
	                }
	            }

	            if (cnt <= m) {
	                rt = mid - 1;
	            } else {
	                lt = mid + 1;
	            }
	        }

	        System.out.println(lt);
	    }
	}