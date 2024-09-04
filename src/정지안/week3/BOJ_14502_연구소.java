package 정지안.week3;

import java.io.*;
import java.util.StringTokenizer;


// ============== 문제 접근 ==============
// n,m이 충분히 작으므로, 3중 for문을 통해 안전 영역의 최대 크기를 저장한다.

public class BOJ_14502_연구소 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                arr[i][j]  = Integer.parseInt(st.nextToken());
            }
        }

        //0 : 벽을 세울 수 있는 빈칸
        //1 : 벽
        //2 : 바이러스

        // 벽을 세운다.

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //복제배열 생성
                int[][] copyArr = new int[n][m];
                for(int l=0; l<n; l++){
                    for(int k=0; k<m;k++){
                        copyArr[l][k] = arr[l][k];
                    }
                }

                //벽1
                if(copyArr[i][j]==0){//현재 위치가 0인 경우에만
                
                }
            }
        }

    }

}
