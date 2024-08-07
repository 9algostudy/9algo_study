package 정지안.week2;

import java.io.*;
import java.util.*;

// ==================== 문제 접근 ====================
// CustomClass인 Edge[] 로 전체 그래프를 관리하고,
// Edge클래스는
// PriorityQueue<Integer> 를 통해 목적지 노드가 작은 것부터 뽑아낼 수 있게 관리한다.



public class BOJ_1260_DFS와BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Edge[] edgeList;
    static Edge[] edgeListForBfs;//복제 엣지리스트생성(bfs용. 왜냐하면 dfs수행시 기존 edgeList의 pq가 poll돼서 데이터가 변경됨.)
    static boolean[] visited;

    // 다음 도착노드를 저장하는 클래스
    static class Edge{
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        public void addNode(int node){
            pq.offer(node);// 다음 노드는 오름차순으로 정렬된다.
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 1. 출발지 노드번호에 접근할 수 있는 리스트
        edgeList = new Edge[n+1];
        edgeListForBfs = new Edge[n+1];
        visited = new boolean[n+1];

        // 2. 리스트 초기화
        for(int i=1; i<=n; i++){
            edgeList[i] = new Edge();
            edgeListForBfs[i] = new Edge();
        }

        // 3. 도착지노드를 넣어준다.
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());

            //양방향관계
            edgeList[startNode].addNode(nextNode);
            edgeList[nextNode].addNode(startNode);
            edgeListForBfs[startNode].addNode(nextNode);
            edgeListForBfs[nextNode].addNode(startNode);
        }




        StringBuilder sbDfs = dfs(v, new StringBuilder());
        bw.write(sbDfs.append("\n").toString());

        Arrays.fill(visited,false);//방문배열초기화
        StringBuilder sbBfs = bfs(v, new StringBuilder());
        bw.write(sbBfs.toString());

        bw.flush();
        bw.close();
        br.close();


    }

    private static StringBuilder bfs(int start, StringBuilder sb) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); //현재 위치를 넣는다.
        visited[start] = true;

        while(!queue.isEmpty()){
            int currentNode = queue.poll();

            sb.append(currentNode).append(" ");

            //다음 위치 방문
            PriorityQueue<Integer> nextNodePq = edgeListForBfs[currentNode].pq;
            while(!nextNodePq.isEmpty()){
                int nextNode = nextNodePq.poll();

                if(!visited[nextNode]){//방문하지않았다면 큐에 저장
                    queue.offer(nextNode);
                    //다음위치 방문 처리
                    visited[nextNode] = true;
                }
            }//while - pq
        }//while - queue

        return sb;
    }//bfs

    private static StringBuilder dfs(int start, StringBuilder sb) {
        visited[start] = true;//현재 위치 방문 처리
        //방문한 위치를 sb에 담는다.
        sb.append(start).append(" ");

        //출발지 노드에서 시작해서,
        //만약 방문하지 않은 곳이라면
        //다음 노드에 방문한다.
        PriorityQueue<Integer> nextEdgePq = edgeList[start].pq;
        while(!nextEdgePq.isEmpty()){
            int nextEdge = nextEdgePq.poll();
            if(!visited[nextEdge]){
                sb = dfs(nextEdge, sb);
            }
        }
         return sb;
    }//dfs
}
