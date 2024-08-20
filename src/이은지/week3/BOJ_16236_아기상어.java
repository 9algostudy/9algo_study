package 이은지.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_16236_아기상어 {

    static int N, x, y, size, minX, minY, minDis;
    static int[][] arr, distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        size = 2;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    x = i;
                    y = j;
                    arr[i][j] = 0; //상어가 있었던 곳은 0으로 갱신 => 9로 두면 탐색 영역에 포함이 되버림
                }
            }
        }

        int eat = 0; // 먹은 물고기 수
        int count = 0; // 이동 횟수
        while (true) {
            distance = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDis = Integer.MAX_VALUE;

            bfs(x, y);

            // 먹을 수 있는 물고기가 있었을 경우
            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++; // 먹은 물고기 수
                arr[minX][minY] = 0; // 먹은 곳은 0으로 갱신
                x = minX;
                y = minY; // 좌표 이동
                count += distance[minX][minY];

                if (eat == size) { // 먹은 수가 사이즈랑 같아지면 크기 +1, 먹은 수 ㄴ초기화
                    size++;
                    eat = 0;
                }
            } else { // 더이상 먹을 물고기가 없는 경우
                break;
            }
        }

        System.out.println(count);

    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point curPos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPos.x + dx[i];
                int ny = curPos.y + dy[i];
                //탐색할 수 있는 곳 & 방문한 적 없는 곳이 아닌곳은 다음으로
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (distance[nx][ny] != 0) {
                    continue;
                }
                if (arr[nx][ny] > size) {
                    continue;
                }

                distance[nx][ny] = distance[curPos.x][curPos.y] + 1;

                //먹을 수 있는 경우
                if (arr[nx][ny] != 0 && arr[nx][ny] < size) {
                    if (minDis > distance[nx][ny]) { // 더 가까운 물고기가 있는 경우
                        minDis = distance[nx][ny];
                        minX = nx;
                        minY = ny;
                    } else if (minDis == distance[nx][ny]) { // 같은 거리인 물고기들이 있는 경우
                        if (minX == nx) { //x도 같다면
                            if (minY > ny) {
                                minX = nx;
                                minY = ny;
                            }
                        } else if (minX > nx) { // 더 위에 있다면
                            minX = nx;
                            minY = ny;
                        }
                    }
                }

                q.add(new Point(nx, ny));

            }
        }
    }
}

