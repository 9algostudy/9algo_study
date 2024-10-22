package 윤다은.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2166_다각형의면적 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		double a = Double.parseDouble(s[0]);
		double b = Double.parseDouble(s[1]);
		
		double f1 = a;
		double f2 = b;
		
		double res1 = 0;
		double res2 = 0;
		
		int c, d;
		for (int i = 1; i < N; i++) {
			s = br.readLine().split(" ");
			c = Integer.parseInt(s[0]);
			d = Integer.parseInt(s[1]);
			res1 += a*d;
			res2 += b*c;
			a = c;
			b = d;
		}
		res1 += a*f2;
		res2 += b*f1;
		
		System.out.println(String.format("%.1f", Math.abs(res1-res2)/2.0));
	}
}
