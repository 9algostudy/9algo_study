package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_18352_특정거리의도시찾기 {
	// 도시
	static ArrayList<Integer>[] city;
	// 방문한 도시
	static boolean[] visited;
	// 출발도시에서 방문 도시까지의 최단거리
	static int[] distanceToK;
	// 찾고자 하는 최단거리
	static int K;
	// 출발 도시
	static int X;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		// 도시 개수
		int N = Integer.parseInt(input[0]);
		// 도로 개수
		int M = Integer.parseInt(input[1]);
		// 찾고자 하는 최단거리
		K = Integer.parseInt(input[2]);
		// 출발 도시
		X = Integer.parseInt(input[3]);
		
		// 거리를 측정할 변수
		int count = 0;
		
		// 최단거리를 만족하는 도시가 있는지 확인할 변수
		boolean flag = false;
		
		city = new ArrayList[N+1];
		visited = new boolean[N+1];
		distanceToK = new int[N+1];
		
		// 도시별 노드 생성
		for(int i = 1; i < city.length; i++) {
			city[i] = new ArrayList<>();
		}
		
		// 노드별 인접 노드(도시) 저장
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			city[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
		}
		
		BFS(X);
		
//		System.out.println(Arrays.toString(distanceToK));
		
		// 찾고자 하는 최단 거리 도시가 있는지 확인
		for(int v = 1; v < N+1; v++) {
			if(distanceToK[v] == K) {
				flag = true;
				System.out.println(v);
			}
		}
		
		// 찾고자 하는 최단 거리 도시가 없으면 -1 출력
		if(!flag) {
			System.out.println(-1);
		}
	}
	
    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작도시 추가
        queue.add(start);
        // 도시를 방문함으로 변경
        visited[start] = true;
        // 시작도시 거리 초기화
        distanceToK[start] = 0;

        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
        	// 현재 노드
            int current = queue.poll();

            // 인접노드들을 방문
            for (int next : city[current]) {
            	// 방문한적이 없는 노드라면
                if (!visited[next]) {
                	// 해당 노드를 방문함으로 변경
                    visited[next] = true;
                    // 시작도시에서 방문도시까지의 거리를 변경
                    distanceToK[next] = distanceToK[current] + 1;
                    // 방문노드 큐에 추가
                    queue.add(next);
                }
            }
        }      
    }
}
