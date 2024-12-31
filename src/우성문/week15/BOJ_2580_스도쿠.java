package 우성문.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int[][] map = new int[9][9];
    // 행, 열, 구역 각각 9가지 = 27
    // 행: 0~8, 열: 9~17, 구역: 18~26
    static boolean[][] visited = new boolean[27][10];
    static ArrayList<int[]> emptyPosition = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) emptyPosition.add(new int[]{i, j});
                visited[i][map[i][j]] = true;
                visited[9+j][map[i][j]] = true;
                visited[18+3*(i/3)+(j/3)][map[i][j]] = true;
            }
        }
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int checkIdx) {
        if (flag) return;
        if (checkIdx == emptyPosition.size()) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append('\n');
            }
            return;
        }
        int[] current = emptyPosition.get(checkIdx);
        for(int value = 1;value<10;value++){
            if(isPossible(current,value)){
                map[current[0]][current[1]] = value;
                int[] arr = {current[0],9+current[1],18+3*(current[0]/3)+(current[1]/3)};
                for(int row : arr){
                    visited[row][value] = true;
                }
                dfs(checkIdx+1);
                for(int row : arr){
                    visited[row][value] = false;
                }
            }
        }
    }

    static boolean isPossible(int[] current, int value) {
        int[] arr = {current[0],9+current[1],18+3*(current[0]/3)+(current[1]/3)};
        for(int row : arr){
            if(visited[row][value]){
                return false;
            }
        }
        return true;
    }
}
