package 우성문.week1;

import java.io.*;
import java.util.*;

public class BOJ_10986_나머지합구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		long[] sum = new long[n + 1];
		line = br.readLine().trim().split(" ");

		HashMap<Long, Long> remain = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			sum[i] = (sum[i - 1] + Integer.parseInt(line[i - 1]) % m) % m;
			if (!remain.containsKey(sum[i])) {
				remain.put(sum[i], 0L);
			}
			remain.put(sum[i], remain.get(sum[i]) + 1);
		}

		long total = (remain.containsKey(0L)) ? remain.get(0L) : 0;
		for (long key : remain.keySet()) {
			long cnt = remain.get(key);
			total += (cnt * (cnt - 1)) / 2;
		}

		System.out.println(total);

	}
}
