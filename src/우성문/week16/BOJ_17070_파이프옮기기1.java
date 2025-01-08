package 우성문.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, result=0;
    static int[][] map;
    static int[][] moveCase = {{0,2},{1,2},{0,1,2}};
    static int[][] dx={{0,1},{1,1},{0,1,1}};
    static int[][] dy={{1,1},{0,1},{1,0,1}};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,2,0);

        System.out.println(result);
    }

    static void dfs(int r, int c, int positionIdx){
        if(r==n&&c==n){
            result++;
            return;
        }
        for(int i = 0;i<dx[positionIdx].length;i++){
            int x = r+dx[positionIdx][i];
            int y = c+dy[positionIdx][i];
            if(x<=n&&y<=n&&map[x][y]==0){
                if(moveCase[positionIdx][i]==2){
                    if(map[r+1][c]==0&&map[r][c+1]==0){
                        dfs(x,y,moveCase[positionIdx][i]);
                    }
                }else{
                    dfs(x,y,moveCase[positionIdx][i]);
                }
            }
        }
    }
}
