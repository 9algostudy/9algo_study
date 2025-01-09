package 박성욱.week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589_보물섬 {
    static char [][] map;
    static int n;
    static int j;
    static int m;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static boolean [][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nmarr = br.readLine().split(" ");
        n = Integer.parseInt(nmarr[0]);
        m = Integer.parseInt(nmarr[1]);
        map = new char[n][m];
        for(int i = 0; i<n;i++){
            String str = br.readLine();
            for(int j = 0; j<m;j++){
                map[i][j] = str.charAt(j);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0 ;i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j] == 'L'){
                    visited = new boolean[n][m];
                    res= Math.max(res, bfs(i,j));
                }
            }
        }
        System.out.println(res);

    }

    private static int bfs(int i, int j) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{i,j,0});
        int max = 0;
        visited[i][j] = true;
        while(!q.isEmpty()){
            int [] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            int dist = now[2];
            max = Math.max(max,dist);
            for(int k = 0; k<4; k++){
                int nx = nowx + dx[k];
                int ny = nowy + dy[k];
                if(nx >= 0 && ny >= 0 && nx<n && ny<m && !visited[nx][ny] && map[nx][ny] == 'L'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,dist+1});
                }
            }
        }
        return max;
    }
}
