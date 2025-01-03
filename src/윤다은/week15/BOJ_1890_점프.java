package 윤다은.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {
	static int N;
	static int[][] map;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[10][10];				//범위 확인....
		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {
					dp[i+map[i][j]][j]+=dp[i][j];
					dp[i][j+map[i][j]]+=dp[i][j];
				}
			}
		}

		System.out.println(dp[N-1][N-1]);

//		Queue<int[]> queue = new LinkedList<>();		//메모리 초과
//		queue.offer(new int[]{0, 0});
//
//		int cnt = 0;
//		int move, mover, movec;
//		while (!queue.isEmpty()) {
//			int[] tmp = queue.poll();
//
//			if (tmp[0] == N-1 && tmp[1] == N-1) cnt++;
//
//			move = map[tmp[0]][tmp[1]];
//			if (move == 0) continue;
//
//			mover = tmp[0] + move;
//			movec = tmp[1] + move;
//
//			if (mover < N) queue.offer(new int[]{mover, tmp[1]});
//			if (movec < N) queue.offer(new int[]{tmp[0], movec});
//		}
//
//		System.out.println(cnt);
	}

//	static void dfs(int r, int c) {			//시간초과
//		if (r == N-1 && c == N-1) {
//			cnt++;
//			return;
//		}
//
//		int move = map[r][c];
//		if (move == 0) return;
//
//		int newr = r + move;
//		int newc = c + move;
//
//		if (newr < N) dfs(newr, c);
//		if (newc < N) dfs(r, newc);
//	}
}
