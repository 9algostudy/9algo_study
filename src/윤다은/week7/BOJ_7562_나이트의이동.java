package 윤다은.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562_나이트의이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] d = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] visited = new int[N][N];
            
            String[] s = br.readLine().split(" ");
            int[] begin = new int[2];
            int[] end = new int[2];
            begin[0] = Integer.parseInt(s[0]);
            begin[1] = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            end[0] = Integer.parseInt(s[0]);
            end[1] = Integer.parseInt(s[1]);

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{begin[0], begin[1], 0});
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                if (tmp[0] == end[0] && tmp[1] == end[1]) {
                	System.out.println(tmp[2]);
                	break;
                }
                for (int i = 0; i < 8; i++) {
                    int x = tmp[0] + d[i][0];
                    int y = tmp[1] + d[i][1];

                    if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] == 1) continue;
                    visited[x][y] = 1;
                    queue.offer(new int[]{x, y, tmp[2]+1});
                }
            }
        }
    }
}
