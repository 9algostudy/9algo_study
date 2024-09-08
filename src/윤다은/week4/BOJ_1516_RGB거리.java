package 윤다은.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1516_RGB거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] RGB = new int[3];
		int[] tmp = new int[3];
		
		String[] s;
		s = br.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			RGB[i] = Integer.parseInt(s[i]);
		}
		for (int i = 1; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				tmp[j] = Integer.parseInt(s[j]) + Math.min(RGB[(j+1)%3], RGB[(j+2)%3]);
			}
			for (int j = 0; j < 3; j++) {
				RGB[j] = tmp[j];
			}
		}
		
		System.out.println(Math.min(RGB[0], Math.min(RGB[1], RGB[2])));
	}
}
