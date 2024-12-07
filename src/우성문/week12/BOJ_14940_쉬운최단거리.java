package 우성문.week12;

import java.io.*;
import java.util.*;

public class BOJ_14940_쉬운최단거리 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int n,m,goalX,goalY;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input/BOJ_14940_쉬운최단거리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    goalX = i;
                    goalY = j;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2],o2[2]);
            }
        });
        pq.offer(new int[]{goalX,goalY,0});
        visited[goalX][goalY] = true;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            for(int i = 0;i<4;i++){
                int x = current[0]+dx[i];
                int y = current[1]+dy[i];
                if(isBound(x,y)&&!visited[x][y]&&map[x][y]!=0){
                    result[x][y] = current[2]+1;
                    visited[x][y] = true;
                    pq.offer(new int[]{x,y,current[2]+1});
                }
            }
        }

        for(int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if(map[i][j]==0||i==goalX&&j==goalY){
                    sb.append('0').append(" ");
                }else{
                    sb.append(result[i][j]==0?"-1":result[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static boolean isBound(int x,int y){
        return !(x<0||x>=n||y<0||y>=m);
    }
}
