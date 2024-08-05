package 윤다은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[] cond = new int[20];
		int[] index = {0, 2, 6, 19};
		int count = 0;
		boolean m = true;
		
		String s =  br.readLine();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			cond[index[i]] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < P; i++) {
			cond[s.charAt(i)-'A']--;
		}
		
		for (int i = 0; i < 4; i++) {
			if (cond[index[i]] > 0) {
				m = false;
				break;
			}
		}
		if (m) {
			count++;
		}
		
		for (int i = P; i < S; i++) {
			m = true;
			cond[s.charAt(i)-'A']--;
			cond[s.charAt(i-P)-'A']++;
			for (int j = 0; j < 4; j++) {
				if (cond[index[j]] > 0) {
					m = false;
					break;
				}
			}
			if (m) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
