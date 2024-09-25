package 우성문.week6;

import java.io.*;
import java.util.*;

public class DDR_FailCode {
	static int n;
	static int[] nums;
	static int[][] moveEnergy = { {}, { 0, 1, 3, 4, 3 }, { 0, 3, 1, 3, 4 }, { 0, 4, 3, 1, 3 }, { 0, 3, 4, 3, 1 } };
	static PriorityQueue<Position>[] pq = new PriorityQueue[2];
	
	static class Position implements Comparable<Position>{
		int left;
		int right;
		int usePower;
		
		public Position(int left, int right, int usePower) {
			this.left = left;
			this.right = right;
			this.usePower = usePower;
		}

		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return Integer.compare(usePower, o.usePower);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week6/BOJ_2342_DDR.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		n = line.length-1;
		if(n==0) {
			System.out.println(0);
		}else {
			nums = new int[n];
			pq[0] = new PriorityQueue<>();
			pq[1] = new PriorityQueue<>();
			for(int i = 0;i<n;i++) nums[i] = Integer.parseInt(line[i]);
			
			int idx = 1;
			int value = 2;
			while(nums[0]==nums[idx]) {
				value++;
				idx++;
			}
			value+=2;
			int x = 0;
			pq[x].offer(new Position(nums[0],nums[idx],value));
			idx++;
			for(int i = idx;i<n;i++) {
				int next = (x+1)%2;
				while(!pq[x].isEmpty()) {
					Position p = pq[x].poll();
					if(p.usePower>value) break;
					pq[next].add(new Position(nums[i], p.right, p.usePower+moveEnergy[p.left][nums[i]]));
					pq[next].add(new Position(p.left, nums[i], p.usePower+moveEnergy[p.right][nums[i]]));
				}
				pq[x].clear();
				value = pq[next].peek().usePower;
				x = (x+1)%2;
			}
			System.out.println(pq[x].poll().usePower);
		}
	}
}
