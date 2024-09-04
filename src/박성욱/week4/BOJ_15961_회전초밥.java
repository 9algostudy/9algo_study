package 박성욱.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_15961_회전초밥 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(str[0]);
		int d = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		int c = Integer.parseInt(str[3]);

		int [] arr = new int[n];
		//각 초밥 종류를 세는 변수
		//모든 종류에 쿠폰수까지 더해서 +1로 생성해줌
		int [] cnter = new int[d+1];
		
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Queue<Integer> q = new LinkedList<>();
		int maxcnt = 0;
		int cnt = 0;
		//초기 배열을 세팅 종류가 없는거라면 카운트 증가
		for(int i =0;i<k;i++) {
			int sushi = arr[i];
			q.add(sushi);
			if(cnter[sushi] == 0) {
				cnt++;
			}
			cnter[sushi]++;
		}
		if(cnter[c] == 0) {
			maxcnt = cnt + 1;
		}
		else
			maxcnt = cnt;
		
		
		for(int i = 0;i<n;i++) {
			int poll = q.poll();
			cnter[poll]--;
			if(cnter[poll]==0) {
				cnt--;
			}
			int next = arr[(i+k)%n];
			q.add(next);
			if(cnter[next]==0) {
				cnt++;
			}
			cnter[next]++;
			int res = cnt;
			if(cnter[c]==0) {
				res+=1;
			}
			maxcnt = Math.max(res, maxcnt);
		}
		
		System.out.println(maxcnt);
	}
}
