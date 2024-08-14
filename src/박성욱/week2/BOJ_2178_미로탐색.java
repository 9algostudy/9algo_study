package 박성욱.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * DFS로 풀면 시간초과뜸
 * 최단거리 아이디어의 경우 DFS가 적합하지 않은 이유는
 * DFS가 재귀를 통해 모든 경로를 탐색하지만 최단거리를 보장할수 없고, 최단거리를 찾으려면
 * 모든 경로를 탐색하면서 최단거리를 계속해서 업데이트해줘야하기 때문임
 * 
 * -------------------------------
 * BFS를 사용해서 미로를 탐색하고 이동하고나서 해당 칸을 +1해줘서
 * 모든 배열의 칸마다 시작지점부터의 depth를 체크할수 있게 함
 */

public class BOJ_2178_미로탐색 {
	// 상하좌우
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int n, m;
	static int[][] arr;
	static boolean visit[][];
	static int mindist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmarr = br.readLine().trim().split(" ");
		n = Integer.parseInt(nmarr[0]);
		m = Integer.parseInt(nmarr[1]);
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().trim().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		visit = new boolean[n][m];

		bfs(0,0);
		//도착지점의 인덱스를 고려해 출력
		System.out.println(arr[n - 1][m - 1]);

//		mindist = Integer.MAX_VALUE;
//		dfs(0, 0, 1);
//		System.out.println(mindist);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { i, j });
		// 큐가 빌때까지
		while (!que.isEmpty()) {
			// 지금 자리 뽑기
			int cur[] = que.poll();
			int x = cur[0];
			int y = cur[1];
			// 뽑고나서 방문체크
			visit[i][j] = true;
			// 상하좌우 탐색
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				// 갈수있는곳인지 탐색
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					// 0이 아니어서 갈수있고, 이미 방문한곳이 아니라면
					if (arr[nx][ny] != 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						// 다음칸의 숫자를 기존의 칸의 depth에서 +1해줌
						arr[nx][ny] = arr[x][y] + 1;
						// 큐에 넣는다
						que.add(new int[] { nx, ny });
					}
				}

			}
		}

	}

    private static void dfs(int x, int y, int dist) {
        // 도착지에 도달하면 최소값 갱신
        if (x == n - 1 && y == m - 1) {
            mindist = Math.min(mindist, dist);
            return;
        }

        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx, ny, dist + 1);
            }
        }

        // 현재 위치에서 탐색 완료 후 방문 상태 초기화
        visit[x][y] = false;
    }
}
