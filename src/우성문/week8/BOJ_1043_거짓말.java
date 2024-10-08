package 우성문.week8;

import java.io.*;
import java.util.*;

public class BOJ_1043_거짓말 {
	static int n, m, root, answer = 0;
	static int[] parent;
	static int[] rank;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week8/BOJ_1043_거짓말.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		parent = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;
		a = br.readLine().split(" ");
		int size = Integer.parseInt(a[0]);
		if (size == 0) {
			System.out.println(m);
		} else {
			root = Integer.parseInt(a[1]);
			for (int i = 1; i < size; i++) {
				int num = Integer.parseInt(a[i+1]);
				union(root, num);
			}
			for (int j = 0; j < m; j++) {
				a = br.readLine().split(" ");
				int len = Integer.parseInt(a[0]);
				int[] set = new int[len];
				set[0] = Integer.parseInt(a[1]);
				for (int i = 1; i < len; i++) {
					set[i] = Integer.parseInt(a[i + 1]);
					union(set[0], set[i]);
				}
				list.add(set);
			}
			for (int[] set : list) {
				boolean flag = true;
				for (int i = 0; i < set.length; i++) {
					if (find(root) == find(set[i])) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer++;
				}
			}
			System.out.println(answer);
		}

	}

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA != rootB) {
			if (rank[rootA] > rank[rootB]) {
				parent[rootB] = rootA;
			} else if (rank[rootA] < rank[rootB]) {
				parent[rootA] = rootB;
			} else {
				parent[rootB] = rootA;
				rank[rootA]++;
			}
		}
	}
}
