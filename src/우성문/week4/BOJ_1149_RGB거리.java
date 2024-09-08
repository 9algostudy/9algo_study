package 우성문.week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_1149_RGB거리 {
	static int n;
	static int[][] map;
	static int[][] result;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][3];
		result = new int[n+1][3];
		String[] line;
		
		for(int i = 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		findMinAnswer(1);
		int min = Math.min(result[n][0], Math.min(result[n][1], result[n][2]));
		System.out.println(min);
	}
	
	static void findMinAnswer(int idx) {
		if(idx == n+1) {
			return;
		}
		for(int i = 0;i<3;i++) {
			result[idx][i] = Math.min(result[idx-1][(i+1)%3],result[idx-1][(i+2)%3])+map[idx-1][i];
		}
		findMinAnswer(idx+1);
	}
}
