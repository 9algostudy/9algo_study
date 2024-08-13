package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12891_DNA비밀번호 {
	public static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] minCount = new int[4];
		int[] count = new int[4];
		
		String[] input = br.readLine().split(" ");

		// 임의 문자열 길이
		int s = Integer.parseInt(input[0]);

		// 부분문자열 길이
		int p = Integer.parseInt(input[1]);

		// 임의로 만든 dna문자열
		String randomDna = br.readLine();	
		
		// 부분문자열에 포함되어야 할 A, C, G, T의 최소 개수 입력 받음
		input = br.readLine().split(" ");
		
		// 부분문자열에 포함되어야 할 A, C, G, T의 최소 개수를 minCount 배열에 담음
		for(int i = 0; i < input.length; i++) {
			minCount[i] = Integer.parseInt(input[i]); 
		}
		
		// 최초 부분문자열(비밈번호) 설정
		for(int i = 0; i < p; i++) {
			count = addDna(randomDna.charAt(i), count);
		}
		
		checkDna(count, minCount);
		
		// 조건에 맞는 부분문자열(비밀번호) 찾기
		for(int i = 0; i < s-p; i++) {
			count = removeDna(randomDna.charAt(i), count);
			count = addDna(randomDna.charAt(p+i), count);
			checkDna(count, minCount);
		}
		
		System.out.println(result);
	}
	
	public static int[] addDna(char dna, int[] count) {
		switch (dna) { 
			case 'A' : 
				count[0]++;
				break;
			case 'C' :
				count[1]++;
				break;
			case 'G' :
				count[2]++;
				break;
			case 'T' :
				count[3]++;
				break;
		}
		return count;
	}
	
	public static int[] removeDna(char dna, int[] count) {
		switch (dna) { 
			case 'A' : 
				count[0]--;
				break;
			case 'C' :
				count[1]--;
				break;
			case 'G' :
				count[2]--;
				break;
			case 'T' :
				count[3]--;
				break;
		}
		return count;
	}
	
	public static void checkDna(int[] count, int[] minCount) {
		boolean flag = true;
		for(int i = 0; i < count.length; i++) {
			if(count[i] < minCount[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			result++;
		}
	}
}
