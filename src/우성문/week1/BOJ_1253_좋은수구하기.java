package 우성문.week1;

import java.io.*;
import java.util.*;

public class BOJ_1253_좋은수구하기 {
	static int goodNumCnt = 0;
	static long [] nums;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		nums = new long [N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i = 0;i<N;i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			if (checkGoodNum(N, i)) {
				goodNumCnt++;
			}
		}

		System.out.println(goodNumCnt);

	}

	public static boolean checkGoodNum(int n, int index) {
		long target = nums[index];
		int left = 0;
		// 입력받은 숫자들 중 음수가 있을 수 있기 때문에 전 범위 다 비교해야함
		int right = n - 1;

		while (left < right) {
			long sum = nums[left] + nums[right];
			if (sum == target) {
				if(index!=left&&index!=right) {
					return true;
				}else if(index == left) {
					left++;
				}else if(index==right) {
					right --;
				}
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		
		return false;
	}
}
