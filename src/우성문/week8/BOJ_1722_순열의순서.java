package 우성문.week8;

import java.io.*;
import java.math.BigInteger;

public class BOJ_1722_순열의순서{
	static int n;
	static BigInteger num,fac;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week8/BOJ_1722_순열의순서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		String[] line = br.readLine().split(" ");
		if(line[0].equals("1")) {
			num = new BigInteger(line[1]);
			num = num.subtract(new BigInteger("1"));
			for(int i = 1;i<=n;i++) {
				fac = new BigInteger(factorial(n-i)+"");
				int p = num.divide(fac).intValue();
				num = num.mod(fac);
				for(int idx = 1;idx<=n;idx++) {
					if(visited[idx]) continue;
					if(p>0) {
						p--;
						continue;
					}
					System.out.print(idx+" ");
					visited[idx] = true;
					break;
				}
			}
		}else {
			nums = new int[n];
			for(int i = 0;i<n;i++) nums[i] = Integer.parseInt(line[i+1]);
			num = new BigInteger("1");
			for(int i = 0;i<n;i++) {
				int cnt = 0;
				visited[nums[i]] = true;
				for(int idx = 1;idx<nums[i];idx++) if(!visited[idx]) cnt++;
				fac = new BigInteger(factorial(n-i-1)+"");
				fac = fac.multiply(new BigInteger(cnt+""));
				num = num.add(fac);
			}
			System.out.println(num);
		}
	}
	
	static long factorial(int n) {
		if(n==1||n==0) return 1;
		return n*factorial(n-1);
	}
	
	static int checkCnt(int n) {
		int cnt = 0;
		for(int i = 1;i<=n;i++) {
			if(!visited[i]) cnt++;
		}
		return cnt;
	}
}
