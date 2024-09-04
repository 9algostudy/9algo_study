package 정지안;

import java.io.*;
import java.util.*;

// =============== 문제 접근 ===============
// dfs로 1~n의 관계를 탐색하는건 O(n*m^2)이니까, 시간초과가 날텐데..
// 인접리스트의 bfs는 O(V+E)니까, 인접리스트bfs로풀어볼까?
// 1~n까지는
// O(n*(n+m))이니까, O(10,000 * (110,000)) = O(100,000,000)이니까 괜찮지않을까?
public class BOJ_1325_효율적인해킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer>[] comList;

    static class Computer implements  Comparable<Computer>{
        int no;
        int max;

        public Computer(int no, int max){
            this.no = no;
            this.max = max;
        }

        @Override
        public int compareTo(Computer o){
            if(max!=max){//max가 다르다면, max 내림차순
                return o.max- max;
            }else{//max가 같다면
                return no-o.no;// 컴퓨터넘버 오름차순
            }
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        comList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            comList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int startCom = Integer.parseInt(st.nextToken());
            int endCom = Integer.parseInt(st.nextToken());

            comList[endCom].add(startCom);
        }


        PriorityQueue<Computer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            int cnt = bfs(i);
            pq.offer(new Computer(i,cnt));
        }

        //pq에서는 max가 가장높은순으로 나온다.
        //따라서, max값을 처음에 설정해놓고
        //만약 max값이 다른녀석이 나온다면 break;

        Computer firstCom = pq.poll();
        int originMax = firstCom.max;
        StringBuilder sb = new StringBuilder();
        sb.append(firstCom.no).append(" ");
        while(!pq.isEmpty()){
            Computer current = pq.poll();
            int currentMax = current.max;
            if(currentMax!=originMax) break;

            sb.append(current.no).append(" ");//max값이 같은경우만 출력
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static int bfs(int start) {
        int max = 0;
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new LinkedList<>();

        //큐에 추가하고 방문처리
        queue.offer(new int[]{start,0});// int[]{시작점, 감염개수}
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int comNo = current[0];
            int virusCnt = current[1];
            max = virusCnt;//큐에 끝으로갈수록 어차피 큰값이오니까. 조건문따로안주고 수행.

            for(int next:comList[comNo]){
                if(!visited[next]){//방문하지않은곳만
                    visited[next] = true;
                    queue.offer(new int[]{next, virusCnt+1});
                }
            }
        }


        return max;
    }
}
