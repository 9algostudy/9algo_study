package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		// 라운드 수 
		int N = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < N; i++) {

			Map<Integer, Integer> A = new HashMap<>();
			Map<Integer, Integer> B = new HashMap<>();

			input = br.readLine().split(" ");

			// 딱지에 나오는 그림 총 개수
			int a = Integer.parseInt(input[0]);

			for(int j = 1; j <= a; j++) {
				int index = Integer.parseInt(input[j]);
				if(A.get(index) == null) {
					A.put(index, 1);
				} else {
					A.put(index, A.get(index) + 1);
				}
			}

			input = br.readLine().split(" ");

			// 딱지에 나오는 그림 총 개수
			int b = Integer.parseInt(input[0]);

			for(int j = 1; j <= b; j++) {
				int index = Integer.parseInt(input[j]);
				if(B.get(index) == null) {
					B.put(index, 1);
				} else {
					B.put(index, B.get(index) + 1);
				}
			}

			isWinner(A, B);
		}
	}

	static void isWinner(Map<Integer, Integer> A, Map<Integer, Integer> B) {

		for(int i = 4; i > 0; i--) {
			if(A.get(i) != null & B.get(i) == null ) {
				System.out.println("A");
				return;
			}

			if(A.get(i) == null & B.get(i) != null ) {
				System.out.println("B");
				return;
			}

			if(A.get(i) != null & B.get(i) != null) {
				if(A.get(i) > B.get(i)) {
					System.out.println("A");
					return;
				} else if(A.get(i) < B.get(i)) {
					System.out.println("B");
					return;
				} 
			}
		}
		
		System.out.println("D");
		return;
	}
}
