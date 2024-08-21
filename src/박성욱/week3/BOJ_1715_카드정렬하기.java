package 박성욱.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n];
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0;i<n;i++) {
//			arr[i] = Integer.parseInt(br.readLine());
			q.add(Integer.parseInt(br.readLine()));
		}
//		int [] sumarr = new int[n];
//		Arrays.sort(arr);
//		int res = 0;
//		sumarr[0] = arr[0];
//        for (int i = 1; i < n; i++) {
//        	sumarr[i] = sumarr[i-1] + arr[i];
//        }
//        System.out.println(Arrays.toString(sumarr));
		
		int res = 0;
		while(q.size()>1) {
			int min = q.poll();
			int min1 = q.poll();
			
			int total = min+ min1;
			res += total;
			q.add(total);
		}
		
        System.out.println(res);
    }
}
		
