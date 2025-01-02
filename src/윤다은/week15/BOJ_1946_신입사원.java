package 윤다은.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1946_신입사원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int cnt = N;
			int[] order = new int[N+1];

			String[] s;
			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				order[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
			}

			int min = order[1];
			for (int i = 2; i <= N; i++) {
				if (min < order[i]) cnt--;
				min = Math.min(order[i], min);
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
