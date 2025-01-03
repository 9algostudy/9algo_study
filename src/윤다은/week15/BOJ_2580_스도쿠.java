package 윤다은.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static int[][] sudoku = new int[9][9];
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) list.add(new int[]{i, j});
			}
		}

		dfs(0);
	}

	static void dfs(int depth) {
		if (depth == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		for (int i = 1; i < 10; i++) {
			if (canFit(r, c, i)) {
				sudoku[r][c] = i;
				dfs(depth+1);
				sudoku[r][c] = 0;
			}
		}
	}

	static boolean canFit(int r, int c, int num) {

		for (int i = 0; i < 9; i++) {
			if (sudoku[r][i] == num) return false;
			if (sudoku[i][c] == num) return false;
		}

		int row = (r/3)*3;
		int col = (c/3)*3;

		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col+3; j++) {
				if (sudoku[i][j] == num) return false;
			}
		}

		return true;
	}
}
