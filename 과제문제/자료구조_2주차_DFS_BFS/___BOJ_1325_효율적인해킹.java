package 자료구조_2주차_DFS_BFS;

import java.io.*;
import java.util.*;

public class ___BOJ_1325_효율적인해킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer>[] comList;
    static int[] cnts;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        comList = new ArrayList[n+1];
        cnts = new int[n+1];
        for(int i=1; i<=n; i++){
            comList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int startCom = Integer.parseInt(st.nextToken());
            int endCom = Integer.parseInt(st.nextToken());

            comList[endCom].add(startCom);
        }



        for(int i=1; i<=n; i++){
            int cnt = bfs(i);
            cnts[i] = cnt;
        }

        //pq에서는 max가 가장높은순으로 나온다.
        //따라서, max값을 처음에 설정해놓고
        //만약 max값이 다른녀석이 나온다면 break;


        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i=1; i<=n; i++){
            if(max<cnts[i]){
                sb = new StringBuilder();
                max = cnts[i];
                sb.append(i).append(" ");
            }else if(max==cnts[i]){
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static int bfs(int start) {
        int max = 0;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        //큐에 추가하고 방문처리
        queue.offer(start);// int[]{시작점, 감염개수}

        visited[start] = true;

        while(!queue.isEmpty()){
            int comNo = queue.poll();
            max++;
            for(int next:comList[comNo]){
                if(!visited[next]){//방문하지않은곳만
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return max;
    }
}
