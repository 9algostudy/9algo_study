package 박성욱.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L;
	static int R;
	static char [] chararr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		chararr = new char[R];
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 0; i<R;i++){
			chararr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chararr);

		dfs(0,0,"");

	}

	private static void dfs(int idx, int depth, String cur) {
		if(depth == L){
			if(check(cur)){
				System.out.println(cur);
			}
			return;
		}
		if(idx == R){ //길이 조건
			return;
		}


		dfs(idx+1,depth+1,cur+chararr[idx]);

		dfs(idx+1,depth,cur);
	}

	private static boolean check(String cur) {
		int jaem = 0;
		int moem = 0;
		for(char ch : cur.toCharArray()){
			if(isMoem(ch)){
				moem++;
			}
			else
				jaem++;
		}
		if(moem>= 1 && jaem >= 2){
			return true;
		}
		return false;
	}

	private static boolean isMoem(char ch) {
		if(ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'){
			return true;
		}
			return false;
	}

}
