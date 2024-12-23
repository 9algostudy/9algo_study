package 우성문.week14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	static StringTokenizer st;
	static BufferedReader br;

	static int a, b, c;
	static long temp, result = 1;
	static String binary;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		temp = a;
		binary = Integer.toBinaryString(b);
		for (int i = binary.length()-1; i >=0; i--) {
			if (binary.charAt(i) == '1') {
				result = (result * temp)%c;
			}
			temp = (temp * temp)%c;
		}
		System.out.println(result);
	}
}
