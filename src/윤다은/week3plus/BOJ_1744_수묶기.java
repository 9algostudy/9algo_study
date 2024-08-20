package 윤다은.week3plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> neg = new PriorityQueue<>(), pos = new PriorityQueue<>();
		int n;
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			if (n > 0) pos.offer(n);
			else neg.offer(n);
		}
		
		int sum = 0;
		int a, b;
		if (pos.size()%2 == 1) sum += pos.poll();
		while (!pos.isEmpty()) {
			a = pos.poll();
			b = pos.poll();
			if (a == 1)
				sum += a+b;
			else
				sum += a*b;
		}
		
		while (neg.size()>1) {
			sum += neg.poll()*neg.poll();
		}
		if (!neg.isEmpty()) sum += neg.poll();
		
		System.out.println(sum);
	}
}
