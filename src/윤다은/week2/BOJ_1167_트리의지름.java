package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer>[] tree = new HashMap[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<>();
		int key, max = 0, sum;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			while ((key = Integer.parseInt(st.nextToken())) != -1) {
				tree[i].put(key, Integer.parseInt(st.nextToken()));
			}
			
			if (tree[i].size() == 1) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			key = queue.poll();
			sum = 0;
			
			//dfs 쓰면 시간초과든 메모리 초과든 날 것 같은데 어떻게 하지ㅣㅣㅣ
		}
		
	}
	
	static void dfs(int key) {
		
	}
}
