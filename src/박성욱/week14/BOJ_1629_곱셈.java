package 박성욱.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//커밋테스트입니다
public class BOJ_1629_곱셈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long res = dfs(a,b,c);

        System.out.println(res);
    }

	private static long dfs(int a, int b,int c) {
		if(b ==	 0) {
			return 1;
		}
		long mid = dfs(a,b/2,c);
		long res = (mid * mid) % c; 
		if (b%2 == 1) {
			res = (res * a) %c;
		}
		return res;
	}
}
