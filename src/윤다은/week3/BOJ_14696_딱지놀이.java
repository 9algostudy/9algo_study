package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int A, B;
		int[] cardA, cardB;
		
		while (N-- > 0) {
			cardA = new int[5];
			cardB = new int[5];
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			for (int i = 0; i < A; i++) {
				cardA[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			B = Integer.parseInt(st.nextToken());
			for (int i = 0; i < B; i++) {
				cardB[Integer.parseInt(st.nextToken())]++;
			}
			
			int i;
			for (i = 4; i >= 1; i--) {
				if (cardA[i] == cardB[i]) continue;
				System.out.println(cardA[i] > cardB[i] ? 'A' : 'B');
				break;
			}
			if (i == 0) {
				System.out.println('D');
			}
		}
		
	}
}
