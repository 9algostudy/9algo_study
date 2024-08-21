	package 박성욱.week2;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	
	public class BOJ_13023_ABCDE {
		static ArrayList<Integer>[] arr;
		static boolean[] visit;
		static boolean arrive;
	
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] nmarr = br.readLine().trim().split(" ");
			int n = Integer.parseInt(nmarr[0]);
			int m = Integer.parseInt(nmarr[1]);
	
			arr = new ArrayList[n];
			visit = new boolean[n];
	
			for (int i = 0; i < n; i++) {
				arr[i] = new ArrayList<>();
			}
	
			for (int i = 0; i < m; i++) {
				String abarr[] = br.readLine().trim().split(" ");
				int a = Integer.parseInt(abarr[0]);
				int b = Integer.parseInt(abarr[1]);
				arr[a].add(b);
				arr[b].add(a);
			}
	
			for (int i = 0; i < n; i++) {
				dfs(i, 1);
				if (arrive == true) {
					break;
				}
			}
	
			if (arrive == true) {
				System.out.println(1);
			} else
				System.out.println(0);
	
		}
	
		private static void dfs(int now, int depth) {
			//종료조건
			if (depth == 5) {
				arrive = true;
				return;
			}
			//현재 방문한곳 체크
			visit[now] = true;
			//노드의 엣지를 탐색해서 방문처리 및 재귀
			for (int i : arr[now]) {
				if (visit[i] == false) {
					dfs(i, depth + 1);
				}
			}
			visit[now] = false;
	
		}
	
	}
