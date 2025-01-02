package 윤다은.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static char[] characters, sb;
	static int[] vowel, consonant;
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		characters = new char[C];
		vowel = new int[C];
		consonant = new int[C];
		sb = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			characters[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(characters);
		char c;
		for (int i = 0; i < C; i++) {
			c = characters[i];
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowel[i] = 1;
			} else {
				consonant[i] = 1;
			}
		}

		password(0, 0, 0, 0);

		System.out.print(res);
	}

	static void password(int idx, int depth, int v, int c) {
		if (depth == L) {
			if (v >= 1 && c >= 2) {
				for (int i = 0; i < L; i++) res.append(sb[i]);
				res.append("\n");
			}
			return;
		}

		for (int i = idx; i < C; i++) {
			sb[depth] = characters[i];
			password(i+1, depth+1, v+vowel[i], c+consonant[i]);
		}
	}
}
