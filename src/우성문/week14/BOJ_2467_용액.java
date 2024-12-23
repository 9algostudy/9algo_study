package 우성문.week14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n, left, right;
	static long min = 2000000000;
	static int[] nums,result = new int[2];

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

		left = 0;
		right = n-1;
		while(left < right) {
			long temp = nums[left] + nums[right];
			if(Math.abs(temp)<Math.abs(min)) {
				min = temp;
				result[0] = left;
				result[1] = right;
				if(min==0) break;
			}
			if(temp<0){
				left++;
			}else{
				right--;
			}
		}
		System.out.println(nums[result[0]]+" "+nums[result[1]]);
	}
}
