package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16928_뱀과사다리게임 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		N += Integer.parseInt(s[1]);
		
		int[][] ladder = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			ladder[i][0] = Integer.parseInt(s[0]);
			ladder[i][1] = Integer.parseInt(s[1]);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int[] visited = new int[101];
		
		queue.offer(new int[] {1, 0});
		visited[1] = 1;
		
		int min = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			if (tmp[0] == 100) {
				min = tmp[1];
				break;
			}
			
			for (int i = 1; i <= 6; i++) {
				int a = tmp[0] + i;
				if (a > 100 || visited[a] == 1) continue;
				visited[a] = 1;
				boolean flag = false;
				for (int j = 0; j < N; j++) {
					if (ladder[j][0] == a) {
						visited[ladder[j][1]] = 1;
						queue.offer(new int[] {ladder[j][1], tmp[1]+1});
						flag = true;
					}
				}
				
				if (flag) {
					continue;
				}
				queue.offer(new int[] {a, tmp[1] + 1});
			}
		}
		
		System.out.println(min);
	}
}
