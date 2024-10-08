package 윤다은.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1043_거짓말 {
	static int[] parent;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		s = br.readLine().split(" ");
		int t = Integer.parseInt(s[0]);		//진실을 아는 사람 수
		
		for (int i = 1; i <= t; i++) {
			parent[Integer.parseInt(s[i])] = 0;	//진실을 알면 부모를 0으로 만든
		}
		
		List<Integer>[] parties = new ArrayList[M];
		for (int i = 0; i < M; i++) {	//파티
			parties[i] = new ArrayList<>();
			
			s = br.readLine().split(" ");
			t = Integer.parseInt(s[0]); 	//파티에 온 사람 수
			
			int first = Integer.parseInt(s[1]); 	//파티 사람 중 맨 처음 사람
			parties[i].add(first);
			int p = findP(first);		//첫 사람의 부모
			for (int j = 2; j <= t; j++) {
				int n = Integer.parseInt(s[j]);
				parties[i].add(n);
				if (p != findP(n)) {	//첫 사람의 부모와 다르면 유니온
					union(p, n);
				}
			}
		}
		
		int cnt = M;					//파티 수로 초기화
		for (int i = 0; i < M; i++) {	//파티를 돌면서
			int p = findP(0);			//0번 사람의 부모를 찾아둔다(진실을 아는 사람들의 부모를 처음에 0으로 설정했기 때문)
			
			for (int n : parties[i]) {	//파티에 사람들을 순회하면서
				if (p == findP(n)) {	//0번 사람의 부모와 같은 부모를 가졌다면
					cnt--;				//이 파티에서는 과장하면 안되니까 cnt--
					break;				//다음 파티로 넘어가기
				}
			}
		}
		
		System.out.println(cnt);		//남은 파티 개수 출력
	}
	
	static int findP(int n) {
		if (parent[n] == n) return n;
		return parent[n] = findP(parent[n]);
	}
	
	static void union(int a, int b) {
		parent[parent[b]] = parent[a];
	}
}
