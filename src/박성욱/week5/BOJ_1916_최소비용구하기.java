package 박성욱.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1916_최소비용구하기 {
	static ArrayList<Node>  [] arr;
	static boolean visit[];
	static int []d;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		visit = new boolean[N+1];
		//거리 배열 초기화
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for(int i = 1;i<N+1;i++) {
			arr[i] = new ArrayList<Node>();
		}
		for(int i = 0;i<M;i++) {
			String str[] = br.readLine().trim().split(" ");
			int f = Integer.parseInt(str[0]);
			int t = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			//노드에 도착지와 가중치를 저장해서 넣어주기
			Node node = new Node(t,w);
			arr[f].add(node);
		}
		
		String ararr [] = br.readLine().trim().split(" ");
		int start = Integer.parseInt(ararr[0]);
		int end = Integer.parseInt(ararr[1]);
		
		//시작점의 거리 배열 0으로 수정
		d[start] = 0;
		dik(start,end);
		System.out.println(d[end]);
	}
	private static void dik(int start,int end) {
		//처음 큐에 넣기
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			//노드 꺼내기
			Node nownode = pq.poll();
			int now = nownode.t;
			//가지치기
            if(now == end){
                break;
            }
			//방문 체크
			if(!visit[now]) {
				visit[now] = true;
				//now의 배열을 꺼내면서
				for(Node x : arr[now]) {
					//앞으로 갈 노드가 방문하지 않았고, 선택 노드 + 비용 < 타겟의 노드 일때 값을 업데이트 시킴 (최단거리)
					if(!visit[x.t] && d[x.t] > d[now] + x.w) {
						d[x.t] = d[now] + x.w;
						//업데이트된 x.t를 큐에넣음
						pq.add(new Node(x.t,d[x.t]));
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int t;
	int w;
	public Node(int t, int w) {
		this.t= t;
		this.w = w;
	}
	//오름차순으로 정렬
	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	};
	
	@Override
	public String toString() {
		return t + " " + w;
	}
}
