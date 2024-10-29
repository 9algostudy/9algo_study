package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_7662_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int T = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> maxq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}

			});

			PriorityQueue<Integer> minq = new PriorityQueue<>();

			HashMap<Integer, Integer> hm = new HashMap<>();

			String[] s;
			while (T-- > 0) {
				s = br.readLine().split(" ");
				int n = Integer.parseInt(s[1]);

				if (s[0].equals("I")) {
					if (maxq.contains(n)) {
						hm.put(n, hm.get(n) + 1);
					} else {
						maxq.offer(n);
						minq.offer(n);
						hm.put(n, 1);
					}
				} else if (s[0].equals("D")) {
					if (!minq.isEmpty()) {
						if (n == 1) {
							int a = maxq.peek();
							int b = hm.get(a);
							if (b == 1) {
								hm.remove(a);
								minq.remove(a);
								maxq.poll();
							}
							else {
								hm.put(a, b-1);
							}
						} else if (n == -1) {
							int a = minq.peek();
							int b = hm.get(a);
							if (b == 1) {
								hm.remove(a);
								maxq.remove(a);
								minq.poll();
							}
							else {
								hm.put(a, b-1);
							}
						}
					}
				}
			}
			System.out.println(minq.isEmpty() ? "EMPTY" : maxq.poll() + " " + minq.poll());
		}
	}
}
