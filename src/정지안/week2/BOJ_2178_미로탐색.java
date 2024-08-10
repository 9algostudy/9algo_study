package 정지안.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ============== 문제 접근 ==============
// bfs
public class BOJ_2178_미로탐색 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][]arr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr  = new int[n][m];
        for(int i=0; i<n; i++){
            String A = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(A.charAt(j)+"");
            }
        }

        int answer = bfs();

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        boolean[][] visited = new boolean[n][m];

        //상하좌우 이동
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        //큐에는 현재 좌표, cnt정보가 필요할 것.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});// y좌표,x좌표,cnt
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int cnt = current[2];

            if(y==n-1 && x==m-1){
                return cnt;
            }

            for(int i=0; i<4; i++){
                int moveY = y+dy[i];
                int moveX = x+dx[i];
                if(isBoundary(moveY,moveX) && arr[moveY][moveX]==1 && !visited[moveY][moveX]){
                    visited[moveY][moveX] = true;
                    queue.offer(new int[]{moveY,moveX,cnt+1});
                }
            }
        }
        return -1;
    }

    private static boolean isBoundary(int moveY, int moveX) {
        return moveY>=0 && moveY<n && moveX>=0 && moveX<m;
    }

}
