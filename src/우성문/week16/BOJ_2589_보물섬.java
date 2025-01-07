package 우성문.week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n,m,max=0;
    static String line;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) == 'L'?1:0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 1){
                    int tempMax = 0;
                    reset();
                    visited[i][j] = true;
                    q = new LinkedList<>();
                    q.add(new int[]{i,j,0});
                    while(!q.isEmpty()){
                        int[] current = q.poll();
                        tempMax = Math.max(tempMax,current[2]);
                        for(int idx = 0;idx<4;idx++){
                            int x = current[0]+dx[idx];
                            int y = current[1]+dy[idx];
                            if(isBound(x,y)&&map[x][y]==1&&!visited[x][y]){
                                visited[x][y] = true;
                                q.add(new int[]{x,y,current[2]+1});
                            }
                        }
                    }
                    max = Math.max(max,tempMax);
                }
            }
        }
        System.out.println(max);
    }

    static void reset(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = false;
            }
        }
    }

    static boolean isBound(int i, int j){
        return !(i<0||i>=n||j<0||j>=m);
    }
}
