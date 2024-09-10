package 우성문.week5;

import java.io.*;

public class BOJ_1976_여행가자 {
	static int n, m;
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week5/BOJ_1976_여행가자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line;
		
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		parents = new int[n+1];
		rank = new int[n+1];
		for(int i= 1;i<n+1;i++) parents[i] =i;
		
		for(int i= 0;i<n;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = i+1;j<n;j++) {
				int num = Integer.parseInt(line[j]);
				if(num==1) {
					union(i+1, j+1);
				}
			}
		}
		line = br.readLine().trim().split(" ");
		boolean flag = true;
		int num = Integer.parseInt(line[0]);
		for(int i = 1;i<line.length;i++) {
			int compareNum = Integer.parseInt(line[i]);
			if(find(num)!=find(compareNum)) {
				flag = false;
				break;
			}
		}
		System.out.println(flag?"YES":"NO");
	}
	
	static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parents[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parents[rootA] = rootB;
            } else {
                parents[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}
