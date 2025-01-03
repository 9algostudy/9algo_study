package 이은지.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면걸어가기 {
	static int T, N, beer;
	static int[] home, festival;
	static ArrayList<int[]> pos;
	static boolean result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());

			home = new int[2];
			festival = new int[2];
			beer = 20;
			pos = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());


			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				pos.add(new int[]{a, b});
			}


			st = new StringTokenizer(br.readLine());
			festival[0] = Integer.parseInt(st.nextToken());
			festival[1] = Integer.parseInt(st.nextToken());

			result = false;

			bfs(home[0], home[1]);

			if (result) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}

	private static void bfs(int x, int y) {

		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[N];

		q.offer(new int[]{x, y});

		while (!q.isEmpty()) {

			int[] now = q.poll();
			x = now[0];
			y = now[1];

			if (Math.abs(x - festival[0]) + Math.abs(y - festival[1]) <= 1000) {
				result = true;
				return;
			}

			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					continue;
				}

				int nx = pos.get(i)[0];
				int ny = pos.get(i)[1];

				if (Math.abs(x - nx) + Math.abs(y - ny) <= 1000) {
					visited[i] = true;
					q.offer(new int[]{nx, ny});
				}
			}
		}
	}

}
