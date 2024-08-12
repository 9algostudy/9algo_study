package 우성문.week2;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {

	public static void main(String[] args) throws Exception {
			System.setIn(new FileInputStream("src/우성문/week2/input.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			StringBuilder sb = new StringBuilder(1000);

			String[] line = br.readLine().trim().split(" ");
			
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			



			bw.write(sb.toString());
			bw.flush();
			bw.close();

		}
}
