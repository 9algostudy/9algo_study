package 우성문.week3;

import java.util.*;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> card = new LinkedList<>();
		for(int i = 1;i<=n;i++) {
			card.offer(i);
		}
		while(card.size()>1) {
			card.poll();
			if(card.size()==1) {
				break;
			}
			card.offer(card.poll());
		}
		System.out.println(card.poll());
	}
}
