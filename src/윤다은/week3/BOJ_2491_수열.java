package 윤다은.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int inc = 0, dec = 0, maxI = 0, maxD = 0;
		int num, prev = 0;
		
		st = new StringTokenizer(br.readLine());
		while (N-- > 0) {
			num = Integer.parseInt(st.nextToken());
			if (num > prev) {
				inc++;
				if (dec > maxD) {
					maxD = dec;
				}
				dec = 1;
			}
			else if (num < prev) {
				dec++;
				if (inc > maxI) {
					maxI = inc;
				}
				inc = 1;
			}
			else {
				inc++;
				dec++;
			}
			prev = num;
		}
		if (dec > maxD) {
			maxD = dec;
		}
		if (inc > maxI) {
			maxI = inc;
		}
		
		System.out.println(maxI > maxD ? maxI : maxD);
	}
}
