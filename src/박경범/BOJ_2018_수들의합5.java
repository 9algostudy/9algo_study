package 박경범;

import java.util.Scanner;

public class BOJ_2018_수들의합5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 연속된 숫자들의 합
		int sum = 0;	
		// 가능한 가지수
		int caseCount = 0;
		// 1부터 N까지 증가하는 수
		int increaseNum = 0;
		
		while(true) {
			sum = 0;
			increaseNum++;
			for(int i = increaseNum; i <= N; i++) {
				sum += i;
				if(sum == N) {
					caseCount++;
					break;
				} else if(sum > N) break;
			} 
			if(increaseNum == N) break;
		}
		
		System.out.println(caseCount);
	}
}
