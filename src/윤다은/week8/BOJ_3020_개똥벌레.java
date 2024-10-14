package 윤다은.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3020_개똥벌레 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int H = Integer.parseInt(s[1]);
		
		int half = N/2;
		int[] down = new int[H+1];
		int[] up = new int[H+1];
		
		for (int i = 0; i < half; i++) {
			down[Integer.parseInt(br.readLine())]++;
			up[H-Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i < H; i++) {
			down[H-i-1] += down[H-i];
			up[i] += up[i-1];
		}
		for (int i = 1; i <= H; i++) {
			down[i] += up[i-1];
		}
		
		int left = 0;
		int right = N;
		int mid, cnt;
		int resMin = 0, resCnt = 0;
		while (left < right) {
			mid = (left+right)/2;
			cnt = 0;
			
			for (int i = 1; i <= H; i++) {
				if (down[i] <= mid) cnt++;
			}
			if (cnt == 0) left = mid+1;
			else {
				right = mid;
				resMin = mid;
				resCnt = cnt;
			}
		}
		
		System.out.println(resMin + " " + resCnt);
	}
}
