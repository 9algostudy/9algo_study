package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//dsfalksjfa;sldfkj
public class BOJ_20056_마법사상어와파이어볼 {
	
	static final int mass = 0;
	static final int speed = 1;
	static final int direction = 2;
	static final int cnt = 3;
	static final int same = 4;
	
	static int dir[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int[][][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		map = new int[N][N][5];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		int r, c;
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			r = Integer.parseInt(s[0])-1;
			c = Integer.parseInt(s[1])-1;
			map[r][c][mass] = Integer.parseInt(s[2]);
			map[r][c][speed] = Integer.parseInt(s[3]);
			map[r][c][direction] = Integer.parseInt(s[4]);
			map[r][c][cnt] = 1;
			map[r][c][same] = 1;
		}
		
		while (K-- > 0) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][cnt] > 1) {
						int count = map[i][j][cnt];
						if (map[i][j][mass]/5 == 0) {
							map[i][j][cnt] = 0;
							continue;
						}
						if (map[i][j][same] == 0) {
							for (int k = 0; k < 8; k+=2) {
								int[] tmp = {i, j, map[i][j][mass]/5, map[i][j][speed]/count, k, count, map[i][j][same]};
								queue.offer(tmp);
							}
						} else {
							for (int k = 1; k < 8; k += 2) {
								int[] tmp = {i, j, map[i][j][mass]/5, map[i][j][speed]/count, k, count, map[i][j][same]};
								queue.offer(tmp);
							}
						}
						map[i][j][cnt] -= count;
						map[i][j][mass]=0;
						map[i][j][speed]=0;
					} else if (map[i][j][cnt] == 1) {
						int[] tmp = {i, j, map[i][j][mass], map[i][j][speed], map[i][j][direction], 1, map[i][j][same]};
						queue.offer(tmp);
						map[i][j][cnt]--;
						map[i][j][mass]=0;
						map[i][j][speed]=0;
					}
				}
			}
			
			while (!queue.isEmpty()) {
				int[] tmp = queue.poll();
				move(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6]);
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][cnt] > 1) {
					sum += map[i][j][mass]/5;
				}
				else if (map[i][j][cnt] == 1) {
					sum += map[i][j][mass];
				}
			}
		}
		
		System.out.println(sum);
	}
	
	public static void move(int i, int j, int ma, int sp, int d, int count, int sa) {
		int newr = (i + dir[d][0]*sp/count)%N;
		int newc = (j + dir[d][1]*sp/count)%N;

		map[newr][newc][cnt]++;
		
		if (count > 0) {
			if (sa == 0) {
				if (d%2 != map[newr][newc][direction]%2) {
					map[newr][newc][same] = 1;
				}
			}
			map[newr][newc][speed] += sp/count;
			map[newr][newc][mass] += ma/5;
		} else {
			map[newr][newc][mass] = ma;
			map[newr][newc][speed] = sp/count;
			map[newr][newc][direction] = d;
			map[newr][newc][same] = 0;
		}
		
	}

}
