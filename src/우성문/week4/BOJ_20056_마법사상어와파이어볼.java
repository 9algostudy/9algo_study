package 우성문.week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_20056_마법사상어와파이어볼 {
	static int[][] map;
	static ArrayList<int[]> fireBalls = new ArrayList<>();
	static ArrayList<Integer> speed = new ArrayList<>();
	static ArrayList<Integer> mass = new ArrayList<>();
	static ArrayList<Integer> direction = new ArrayList<>();
	static int[][] d = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);

		for (int i = 0; i < m; i++) {
			line = br.readLine().trim().split(" ");
			fireBalls.add(new int[] { Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1 });
			mass.add(Integer.parseInt(line[2]));
			speed.add(Integer.parseInt(line[3]));
			direction.add(Integer.parseInt(line[4]));
		}

		while (k-- > 0) {
			StringBuilder[][] temp = new StringBuilder[n][n];
			for (int i = 0; i < fireBalls.size(); i++) {
				if(mass.get(i)==0) {
					continue;
				}
				int[] coordinate = fireBalls.get(i);
				int idx = direction.get(i);
				coordinate[0] += speed.get(i)*d[idx][0];
				coordinate[1] += speed.get(i)*d[idx][1];
				coordinate[0] %= n;
				coordinate[1] %= n;
				coordinate[0] += coordinate[0]<0?n:0;
				coordinate[1] += coordinate[1]<0?n:0;
				fireBalls.set(i, coordinate);
				if (temp[coordinate[0]][coordinate[1]] == null) {
					temp[coordinate[0]][coordinate[1]] = new StringBuilder();
				}
				if(mass.get(i)==0) {
					continue;
				}
				temp[coordinate[0]][coordinate[1]].append(i).append(" ");
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					StringBuilder tempSb = temp[i][j];
					if (tempSb == null || tempSb.toString().trim().split(" ").length == 1) {
						continue;
					}
					String[] balls = tempSb.toString().trim().split(" ");
					int size = balls.length;
					int[] idxList = new int[size];
					idxList[0] = Integer.parseInt(balls[0]);
					int[] splitCoordinate = fireBalls.get(idxList[0]);
					int totalMass = mass.get(idxList[0]);
					int totalSpeed = speed.get(idxList[0]);
					int check = direction.get(idxList[0]) % 2;
					for (int p = 1; p < size; p++) {
						idxList[p] = Integer.parseInt(balls[p]);
						totalMass += mass.get(idxList[p]);
						totalSpeed += speed.get(idxList[p]);
						if (check != direction.get(idxList[p]) % 2) {
							check = -1;
						}
					}
					Arrays.sort(idxList);
					for (int p = size - 1; p >= 0; p--) {
						mass.set(idxList[p],0);
					}

					int splitMass = totalMass / 5;
					if (splitMass == 0) {
						continue;
					}
					int splitSpeed = totalSpeed / size;
					for (int p = 0; p < 4; p++) {
						fireBalls.add(new int[] {splitCoordinate[0],splitCoordinate[1]});
						mass.add(splitMass);
						speed.add(splitSpeed);
						int idx = (check == -1 ? 2 * p + 1 : 2 * p);
						direction.add(idx);
					}
				}
			}
		}
		int totalMass = 0;
		for (int entity : mass) {
			totalMass += entity;
		}
		System.out.println(totalMass);

	}
}
