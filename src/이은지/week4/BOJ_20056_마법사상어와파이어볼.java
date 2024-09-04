package 이은지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ_20056_마법사상어와파이어볼 {

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K, result;
    static ArrayList<Fireball>[][] arr;
    static ArrayList<Fireball> balls;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        balls = new ArrayList<>();
        arr = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball ball = new Fireball(r, c, m, s, d);

            balls.add(ball); // ball 목록에도 추가
        }

        result = 0;
        for (int i = 0; i < K; i++) {
            moveFireball();
            combination();
        }

        for (Fireball ball : balls) {
            result += ball.m;
        }

        System.out.println(result);

    }

    private static void moveFireball() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }

        for (Fireball ball : balls) {

            int x = (ball.r + N + dx[ball.d] * (ball.s % N)) % N;
            int y = (ball.c + N + dy[ball.d] * (ball.s % N)) % N; // +N은 음수 때문

            ball.r = x;
            ball.c = y;

            arr[x][y].add(ball);
        }
    }

    private static void combination() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].size() < 2) {
                    continue;
                }

                int cnt = arr[i][j].size(); // 합쳐지는 볼 개수
                int mSum = 0; // 질량 총합
                int sSum = 0; // 속력 총합
                boolean even = false;
                boolean odd = false;
                for (Fireball ball : arr[i][j]) {
                    mSum += ball.m;
                    sSum += ball.s;
                    if (ball.d % 2 == 0) { // 짝수면
                        even = true;
                    } else {
                        odd = true;
                    }
                    balls.remove(ball); // 분열된 것 제거
                }

                mSum /= 5;
                if (mSum == 0) {
                    continue;
                }
                sSum /= cnt;

                if (even && odd) { //방향 1, 3, 5, 7
                    for (int d = 1; d < 8; d += 2) {
                        balls.add(new Fireball(i, j, mSum, sSum, d));
                    }
                } else { //0, 2, 4, 6
                    for (int d = 0; d < 8; d += 2) {
                        balls.add(new Fireball(i, j, mSum, sSum, d));
                    }
                }

            }
        }
    }

}
