package 정지안.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ============= 문제 접근 =============
// 양방향 연결 그래프로 만든다.

public class BOJ_11724_연결요소의개수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt;
    static List<Integer>[] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        node = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            node[i] = new ArrayList<>();
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //노드의 양방향 연결
            node[u].add(v);
            node[v].add(u);
        }


        for(int i=1; i<=n; i++){
            if(!visited[i]){//방문하지 않은 경우에만
                dfs(i);     // dfs 수행
                cnt++;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();



    }

    private static void dfs(int start) {
        visited[start] = true; //현재 위치 방문처리.

        //방문하지 않은 곳만 dfs를통해 싹 방문처리.
        for(int next:node[start]){
            if(!visited[next]){
                dfs(next);
            }
        }

    }
}
