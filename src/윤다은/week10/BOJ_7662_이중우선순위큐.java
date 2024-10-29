package 윤다은.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_7662_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int T = Integer.parseInt(br.readLine());

//			PriorityQueue<Integer> maxq = new PriorityQueue<>(new Comparator<Integer>() {
//
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//
//			});
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

			PriorityQueue<Integer> minq = new PriorityQueue<>();

			HashMap<Integer, Integer> hm = new HashMap<>();

			String[] s;
			while (T-- > 0) {
				s = br.readLine().split(" ");
				int n = Integer.parseInt(s[1]);

				if (s[0].equals("I")) {
						hm.put(n, hm.getOrDefault(n, 0) + 1);
						maxq.offer(n);
						minq.offer(n);
				} else {
					if (hm.size() == 0)
						continue;
					if (n == 1) {
						int a;
						while (true) {
							a = maxq.poll();
							int b = hm.getOrDefault(a, 0);
							if (b == 0)
								continue;
							if (b == 1) {
								hm.remove(a);
							} else {
								hm.put(a, b - 1);
							}
							break;
						}
					} else {
						int a;
						while (true) {
							a = minq.poll();
							int b = hm.getOrDefault(a, 0);
							if (b == 0)
								continue;
							if (b == 1) {
								hm.remove(a);
							} else {
								hm.put(a, b - 1);
							}
							break;
						}
					}
				}
			}
			if (hm.size() == 0) {
				System.out.println("EMPTY");
			} else {
				int max=0, min=0;
				while (true) {
					max = maxq.poll();
					if (hm.getOrDefault(max, 0) == 0) continue;
					break;
				}
				while (true) {
					min = minq.poll();
					if (hm.getOrDefault(min, 0) == 0) continue;
					break;
				}
				System.out.println(max + " " + min);
			}
			
		}
	}
}
