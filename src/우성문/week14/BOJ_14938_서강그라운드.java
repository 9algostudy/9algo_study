package 우성문.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  실수 1) 방문 순서에 따라 방문할 수 있는 장소가 달라진다
 * 		- 처음에는 길이별로 정렬해서 탐색했으나 틀렸어서 방문에 상관없이 들리게했고 처음 방문할 떄만 아이템 수 더함
 *  실수 2) 고립된 지역이 최대값일 수 있음!
 */
public class BOJ_14938_서강그라운드 {
	static StringTokenizer st;
	static BufferedReader br;

	static int n, m, r, cnt, max = 0;
	static int[] itemCnt;
	static boolean[] visited;
	static List<int[]> list;
	static HashMap<Integer, List<int[]>> graph = new HashMap<>();


	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		itemCnt = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++){
			itemCnt[i] = Integer.parseInt(st.nextToken());
			graph.put(i, new ArrayList<>());
		}

		for(int i = 0;i<r;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list = graph.get(a);
			list.add(new int[]{b,len});
			graph.put(a,list);
			list = graph.get(b);
			list.add(new int[]{a,len});
			graph.put(b,list);
		}

		for(Integer key : graph.keySet()){
			visited = new boolean[n+1];
			cnt = itemCnt[key];
			visited[key] = true;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{key,0});
			while(!q.isEmpty()){
				int[] current = q.poll();
				for(int[] next : graph.get(current[0])){
					if(current[1]+next[1]<=m){
						if(!visited[next[0]]){
							cnt += itemCnt[next[0]];
						}
						visited[next[0]] = true;
						q.add(new int[]{next[0],current[1]+next[1]});
					}
				}
			}
			max = Math.max(max,cnt);
		}

		System.out.println(max);
	}
}
