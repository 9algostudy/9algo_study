package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5052_전화번호목록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			
			List<String> phone = new ArrayList<>();
			for (int i = 0; i < N; i++)	 {
				String s = br.readLine();
				phone.add(s);
				max = Math.max(max, s.length());
			}
			
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < phone.size(); j++) {
					
				}
			}
		}
	}
}
