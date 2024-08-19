package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] rooms = new int[2][6];
		int res = 0;
		int sex, grade;
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			sex = Integer.parseInt(st.nextToken());
			grade = Integer.parseInt(st.nextToken()) - 1;
			rooms[sex][grade]++;
			if (rooms[sex][grade] == 1) {
				res++;
			}
			else if (rooms[sex][grade] == K) {
				rooms[sex][grade] = 0;
			}
		}
		
		System.out.println(res);
		
	}
}
