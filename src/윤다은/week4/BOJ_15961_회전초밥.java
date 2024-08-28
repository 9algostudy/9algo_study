package 윤다은.week4;

import java.io.*;
import java.util.*;

public class BOJ_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int plates = Integer.parseInt(s[0]);
		int num = Integer.parseInt(s[2]);
		int coupon = Integer.parseInt(s[3]);
		int service = 1;
		
		Map<Integer, Integer> sushi = new HashMap<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		
//		sushi.put(coupon, 1);
		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == coupon) service = 0;
			if (sushi.get(n) == null) {
				sushi.put(n, 1);
			} else {
				sushi.put(n, sushi.get(n)+1);
			}
			queue.offer(n);
			queue2.offer(n);
		}

		int max = queue.size();
		
		int n, size;
		for (int i = 0; i < plates-num; i++) {
			n = queue.poll();
			size = sushi.remove(n);
			if (size > 1)
				sushi.put(n, size-1);
			else 
				if (n == coupon) service = 1;
			
			n = Integer.parseInt(br.readLine());
			if (n == coupon) service = 0;
			if (sushi.get(n) == null) {
				sushi.put(n, 1);
			} else {
				sushi.put(n, sushi.get(n)+1);
			}
			
			queue.offer(n);
			max = Math.max(max, sushi.size() + service);
		}
		
		for (int i = 0; i < num-1; i++) {
			n = queue.poll();
			size = sushi.remove(n);
			if (size > 1)
				sushi.put(n, size-1);
			else
				if (n == coupon) service = 1;
			
			n = queue2.poll();
			if (n == coupon) service = 0;
			if (sushi.get(n) == null) {
				sushi.put(n, 1);
			} else {
				sushi.put(n, sushi.get(n)+1);
			}
			
			queue.offer(n);
			max = Math.max(max, sushi.size() + service);
		}
		
		System.out.println(max);
	}
}
