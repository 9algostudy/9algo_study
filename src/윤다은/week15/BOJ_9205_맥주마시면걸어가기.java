package 윤다은.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9205_맥주마시면걸어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");

			int curr = Integer.parseInt(s[0]);
			int curc = Integer.parseInt(s[1]);

			int[][] store = new int[N+1][2];
			for (int i = 0; i <= N; i++) {
				s = br.readLine().split(" ");
				store[i][0] = Integer.parseInt(s[0]);
				store[i][1] = Integer.parseInt(s[1]);
			}

			int destr = store[N][0];
			int destc = store[N][1];
			boolean flag = false;

			Queue<int[]> queue = new LinkedList<>();
			int[] visited = new int[N+1];
			queue.offer(new int[]{curr, curc});

			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();

				if (tmp[0] == destr && tmp[1] == destc) {
					flag = true;
					break;
				}

				for (int i = 0; i <= N; i++) {
					if (visited[i] == 1) continue;
					if (Math.abs(store[i][0] - tmp[0]) + Math.abs(store[i][1] - tmp[1]) <= 1000) {
						visited[i] = 1;
						queue.offer(new int[]{store[i][0], store[i][1]});
					}
				}
			}

			if (flag) sb.append("happy");
			else sb.append("sad");

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
