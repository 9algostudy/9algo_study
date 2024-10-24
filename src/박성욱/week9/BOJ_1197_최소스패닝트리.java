package 박성욱.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1197_최소스패닝트리 {
	static int p[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String vestr[] = br.readLine().trim().split(" ");
		int V = Integer.parseInt(vestr[0]);
		int E = Integer.parseInt(vestr[1]);

		ArrayList<Node> list = new ArrayList<>();
		// 부모설정
		p = new int[V + 1];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		for (int i = 0; i < E; i++) {
			String str[] = br.readLine().trim().split(" ");
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int v = Integer.parseInt(str[2]);
			Node node = new Node(s, e, v);
			list.add(node);
		}

		Collections.sort(list);

		int sum = 0;
		int pick = 0; 

		for (int i = 0; i < E; i++) {

			int px = findSet(list.get(i).s);
			int py = findSet(list.get(i).e);

			if (px != py) {
				union(px, py);
				sum += list.get(i).v;
				pick++;
			}

			if (pick == (V - 1))
				break;

		}

		System.out.println(sum);

	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}

}

class Node implements Comparable<Node> {
	int s;
	int e;
	int v;

	public Node(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}

}
