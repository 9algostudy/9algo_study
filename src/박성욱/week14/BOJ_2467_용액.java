package 박성욱.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static int n;
	static int [] arr;
	static int [] ans = new int [2];
	public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  n = Integer.parseInt(br.readLine());
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  arr = new int[n];
	  for (int i = 0; i < n; i++) {
	  	arr[i] = Integer.parseInt(st.nextToken());
	  }
	  twopoint();

	  System.out.println(arr[ans[0]] + " " + arr[ans[1]]);

	}

	private static void twopoint() {
		int left = 0;
		int right = n-1;
		long min = Integer.MAX_VALUE;
		while (left < right) {
			long sum = arr[left] + arr[right];
			if(min>Math.abs(sum)){
				min = Math.abs(sum);
				ans[0] = left;
				ans[1] = right;
			}
			if(sum>=0){
				right--;
			}
			else{
				left++;
			}
		}

	}

}
