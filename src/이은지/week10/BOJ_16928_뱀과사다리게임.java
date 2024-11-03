package 이은지.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16928_뱀과사다리게임 {

	static int N, M;
	static int[] ladderSnake, count;
	static  boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		count = new int[101];
		ladderSnake = new int[101];
		visited = new boolean[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			ladderSnake[x] = y;
		}

		bfs();

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		count[1] = 0;
		visited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == 100) {
				System.out.println(count[cur]);
				return;
			}

			for (int i = 1; i < 7; i++) {
				int next = cur + i;

				if (next > 100) continue;
				if (visited[next]) continue;

				visited[next] = true;

				int target = ladderSnake[next];

				if (target != 0) {
					if (!visited[target]) {
						q.offer(target);
						visited[target] = true;
						count[target] = count[cur] + 1;
					}
				} else {
					q.offer(next);
					count[next] = count[cur] + 1;
				}
			}
		}

	}

}
