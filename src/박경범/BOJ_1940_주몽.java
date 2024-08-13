package 박경범;

import java.util.Scanner;

public class BOJ_1940_주몽 {
	public static void main(String[] args) {
		 	Scanner sc = new Scanner(System.in);
		 	
		 	int N = sc.nextInt();
		 	int M = sc.nextInt(); 	
		 	
		 	int[] material = new int[N];
		 	
		 	// 1부터 N까지 증가
		 	int count = 0;
		 	
		 	// 두 재료의 고유번호 합
		 	int sum = 0;
		 	
		 	// 결과
		 	int result = 0;
		 	
		 	for(int i = 0; i < material.length; i++) {
		 		material[i] = sc.nextInt();
		 	}
		 	
		 	for(int i = 0; i < N-1; i++) {
		 		for(int j = count+1; j < N; j++) {
		 			sum += material[count] + material[j];
		 			// System.out.println("material["  + count + "] + material[" + j+ "] = " + sum);
		 			if(sum == M) {
		 				result++;
		 			}
	 				sum = 0;
		 		}
		 		count++;
		 	}
		 	
		 	System.out.println(result);
	}
}
