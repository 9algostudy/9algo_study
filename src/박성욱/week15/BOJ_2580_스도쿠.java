package 박성욱.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static int[][] arr = new int[9][9]; // 스도쿠 판

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);
	}

	private static boolean solve(int row, int col) {
		if (row == 9) {
			printSolution();
			return true;
		}

		if (arr[row][col] != 0) {
			if (col == 8) {
				return solve(row + 1, 0);
			} else {
				return solve(row, col + 1);
			}
		} else {
			for (int num = 1; num <= 9; num++) {
				if (isValid(row, col, num)) {
					arr[row][col] = num;
					if (col == 8) {
						if (solve(row + 1, 0)) return true;
					} else {
						if (solve(row, col + 1)) return true;
					}
					arr[row][col] = 0;
				}
			}
		}
		return false;
	}

	private static boolean isValid(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == num || arr[i][col] == num) {
				return false;
			}
		}

		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (arr[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	private static void printSolution() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
