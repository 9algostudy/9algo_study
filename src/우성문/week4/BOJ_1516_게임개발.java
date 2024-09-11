package 우성문.week4;

import java.io.*;
import java.util.*;

public class BOJ_1516_게임개발 {
	static int n;
	static int[] degree;
	static int[][] map;
	static int[] buildTime;
	static boolean[] isComplete;
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/week4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine().trim());
        map = new int[n+1][n+1];
        degree = new int[n+1];
        buildTime = new int[n+1];
        isComplete = new boolean[n+1];
        String[] line;
        for(int i = 1;i<=n;i++) {
        	line = br.readLine().trim().split(" ");
        	map[i][i] = Integer.parseInt(line[0]);
        	for(int j = 1;j<line.length-1;j++) {
        		int start = Integer.parseInt(line[j]);
        		map[start][i] = 1;
        	}
        	degree[i] = line.length-2;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<=n;i++) {
        	if(degree[i]==0) {
        		q.add(i);
        		buildTime[i] = map[i][i];
        	}
        }
        while(!q.isEmpty()) {
        	int current = q.poll();
			int time = buildTime[current];
			for(int i = 1;i<n+1;i++) {
				if(map[current][i]==1) {
					degree[i]--;
					if(buildTime[i]==0) {
						buildTime[i] = time + map[i][i];
					}else if(!isComplete[i]){
						buildTime[i] = Math.max(buildTime[i], time + map[i][i]);
					}
					if(degree[i]==0) {
						isComplete[i] = true;
						q.offer(i);
					}
				}
			}
        }
        for(int i = 1;i<=n;i++) {
        	System.out.println(buildTime[i]);
        }
	}

}
