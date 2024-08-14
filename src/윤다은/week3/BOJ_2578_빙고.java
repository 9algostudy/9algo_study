package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] bingo = new int[26][2];
		int[] row = new int[5], col = new int[5];
		int d1 = 0, d2 = 0;
		int num, res = 0, cnt = 0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				num = Integer.parseInt(st.nextToken());
				bingo[num][0] = i;
				bingo[num][1] = j;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				
				num = Integer.parseInt(st.nextToken());
				row[bingo[num][0]]++;
				col[bingo[num][1]]++;
				
				if (row[bingo[num][0]] == 5) res++;
				if (col[bingo[num][1]] == 5) res++;
				
				if (bingo[num][0] == bingo[num][1]) {
					d1++;
					if (d1 == 5) res++;
				}
				if (bingo[num][0] == (4-bingo[num][1])) {
					d2++;
					if (d2 == 5) res++;
				}
				
				if (res >= 3) {
					System.out.println(cnt);
					return;
				}
				
			}
		}
		
	}
}
