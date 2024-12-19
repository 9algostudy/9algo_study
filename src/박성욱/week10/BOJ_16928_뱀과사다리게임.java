package 박성욱.week10;

import java.io.*;
import java.util.*;

public class BOJ_16928_뱀과사다리게임 {

	static int arr[], n, m; // 뱀과 사다리 정보를 저장하는 배열과 입력값 n(사다리 수), m(뱀 수)
	static boolean visit[]; // 방문 여부를 체크하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().trim().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[101]; // 보드 칸이 100칸이므로 101 크기로 배열 생성
		visit = new boolean[101]; // 각 칸에 대한 방문 여부 체크

		// 사다리 정보 입력
		for (int i = 0; i < n; i++) {
			String str1[] = br.readLine().trim().split(" ");
			arr[Integer.parseInt(str1[0])] = Integer.parseInt(str1[1]);
		}
		// 뱀 정보 입력
		for (int i = 0; i < m; i++) {
			String str1[] = br.readLine().trim().split(" ");
			arr[Integer.parseInt(str1[0])] = Integer.parseInt(str1[1]);
		}

		bfs(1); // 시작 위치가 1이므로, bfs 탐색을 시작
	}

	// BFS를 사용하여 최단 횟수로 100번 칸에 도달할 수 있는 이동 수를 계산하는 함수
	static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>(); // 큐를 생성하여 위치와 이동 횟수를 저장
		q.add(new int[]{start, 0}); // 시작 위치(1번 칸)와 초기 이동 횟수(0)를 큐에 추가
		visit[start] = true; // 시작 위치 방문 표시
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int now = p[0];  // 현재 칸 위치
			int cnt = p[1];  // 현재까지 이동 횟수

			// 100번 칸에 도달한 경우, 이동 횟수를 출력하고 종료
			if (now == 100) {
				System.out.println(cnt);
				return;
			}

			// 주사위 눈금(1부터 6까지)을 이동
			for (int i = 1; i <= 6; i++) {
				int next = now + i; // 다음 칸 계산

				if (next <= 100) { // 100번 칸을 넘지 않는 경우만 고려
					if (arr[next] != 0) { // 다음 칸이 사다리나 뱀에 연결된 경우
						next = arr[next];  // 연결된 칸으로 이동
					}
					if (!visit[next]) { // 아직 방문하지 않은 경우에만 추가
						visit[next] = true; // 방문 표시
						q.add(new int[]{next, cnt + 1}); // 이동 후 새로운 위치와 횟수 저장
					}
				}
			}
		}
	}
}
