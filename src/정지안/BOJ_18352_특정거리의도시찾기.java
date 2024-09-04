package 정지안;

import java.io.*;
import java.util.*;

// ==================== 문제 접근 ====================
// bfs로, 시작점에서 x번째에 해당하는 queue의 사이즈를 반환하기.

// 아래조건에서 bfs가 괜찮은가?
// 2<=n<=300,000
// 1<=m<=1,000,000
// 1<=k<=300,000

// 인접리스트 bfs 시간복잡도 : O(V+E)
// 즉, O(n+m)이므로 시간복잡도는 괜찮다.


public class BOJ_18352_특정거리의도시찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 1. 인접리스트 생성
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        // 2. 출발지-도착지 초기화
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);//단방향 추가
        }

        // 3. bfs로 출발도시 x, 도착지 거리가 k인 도시 탐색
        Queue<int[]> pq = bfs(x,k);
        if(pq == null){
            bw.write("-1\n");
        }else{
            List<Integer> listForSort = new ArrayList<>();
            while(!pq.isEmpty()){
                listForSort.add(pq.poll()[0]);
            }

            Collections.sort(listForSort);
            for(int answer : listForSort){
                bw.write(answer+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();






    }

    private static Queue<int[]> bfs(int x, int k) {
        Queue<int[]> pq = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        //출발 도시를 pq에 추가
        pq.offer(new int[]{x, 0}); // int[]{도시, 거리}
        visited[x] = true;//방문처리

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentCity = current[0]; //현재 도시를 pq에서 poll
            int currentDistance = current[1];

            if(currentDistance == k){
                pq.offer(current);//큐에 현재 것을 다시 집어담아서
                return pq;//현재 k거리의 pq자체를 반환한다.
            }

            for(int next: list[currentCity]){
                if(!visited[next]){//방문하지 않은 경우만 방문.
                    pq.offer(new int[]{next, currentDistance+1});
                    visited[next] = true;
                }
            }
        }


        return null;
    }
}
