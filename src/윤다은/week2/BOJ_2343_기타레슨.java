package 윤다은.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] times = new int[N];
		int[] sums = new int[M];
		int[] pointer = new int[M-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
			sums[i*M/N] += times[i];
		}
		
		for (int i = 0; i < M-1; i++) {
			pointer[i] = N/M*(i+1);
		}
		
		int min = sums[0], max = sums[0], cur = 0;
		int minIndex = 0, maxIndex = 0;
		
		for (int i = 1; i < M; i++) {
			if (min > sums[i]) {
				min = sums[i];
				minIndex = i;
			} else if (max < sums[i]){
				max = sums[i];
				maxIndex = i;
			}
		}
		
		do {
			cur = max;
			
			if (minIndex < maxIndex) {
				for (int i = maxIndex-1; i >= minIndex; i--) {
					sums[i+1] -= times[pointer[i]];
					sums[i] += times[pointer[i]++];
					if (sums[i] < max) {
						break;
					}
				}
			} else {
				for (int i = maxIndex; i > minIndex; i++) {
					sums[i] -= times[pointer[i]];
					sums[i+1] += times[pointer[i]++];
					if (sums[i+1] < max) {
						break;
					}
				}
			}
			
			min = sums[0];
			max = sums[0];
			for (int i = 1; i < M; i++) {
				if (min > sums[i]) {
					min = sums[i];
					minIndex = i;
				} else if (max < sums[i]){
					max = sums[i];
					maxIndex = i;
				}
			}
			
		} while (cur > max);
		
		System.out.println(cur);
	}
}
