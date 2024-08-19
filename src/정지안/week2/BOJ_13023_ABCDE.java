package 정지안.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// ================= 문제 접근 =================
// 1. 인접리스트로 친구 관계를 양방향 설정
// 2. dfs로 모든 요소를 순회하며, depth가 4일때까지 갈 수 있다면 "1"출력

//엥 틀렸네?
//=>실수로 dfs첫 방문 초기화 안했음.
public class BOJ_13023_ABCDE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean findAnswer = false;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static List<Integer>[] listArr;



    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        listArr = new ArrayList[n];

        // 인접리스트 생성
        for(int i=0; i<n; i++){
            listArr[i] = new ArrayList<>();
        }

        // 인접리스트 초기화
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            //양방향 관계 설정
            listArr[start].add(end);
            listArr[end].add(start);
        }

        //모든 친구리스트를 dfs로 순회
        for(int i=0; i<n; i++){
            if(findAnswer) break;
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(i,0, visited);
        }

        if(findAnswer) sb.append("1\n");
        else sb.append("0\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int idx, int depth, boolean[] visited) {
        if(findAnswer) return;

        if(depth == 4){
            //성공!
            findAnswer = true;
            return;
        }

        //현재 인덱스에서 다음 인덱스 순회
        for(int x : listArr[idx]){
            if(!visited[x]){
                //현재 인덱스 방문처리.
                visited[x] = true;
                dfs(x,depth+1,visited);
                //백트래킹
                visited[x] = false;
            }
        }

    }//dfs

}//Main Class
