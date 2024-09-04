package 우성문.week3;

import java.io.*;
import java.util.*;

public class BOJ_16236_아기상어 {
	static HashMap<Integer,ArrayList<int[]>> fishs = new HashMap<>();
	static int[][] map;
	static int n;
	static int[] shark = new int[2];
	static int sharkSize = 2;
	static int minLen;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		for(int i = 0;i<n;i++) {
			String[] line = br.readLine().trim().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if(map[i][j]==9) {
					shark[0] = i;
					shark[1] = j;
					// 망할 초기화
					map[i][j]=0;
				}else if(map[i][j]!=0) {
					ArrayList<int[]> list;
					if(fishs.containsKey(map[i][j])) {
						list = fishs.get(map[i][j]);
					}else {
						list = new ArrayList<>();
					}
					list.add(new int[] {i,j,map[i][j]});
					fishs.put(map[i][j], list);
				}
			}
		}
		if(fishs.size() == 0) {
			System.out.println(0);
		}else {
			ArrayList<Integer> fishSize = new ArrayList<>(fishs.keySet());
			Collections.sort(fishSize);
			int time = 0;
			int eatCnt=0;
			
			// 먹을 수 있는 물고기 위치
			ArrayList<int[]> position = new ArrayList<>();
			
			// 상어 크기가 커질 수 있으므로 한번먹을 때 마다 먹을 수 있는 물고기 위치 리스트 갱신
			while(true) {
				// 먹을 수 있는 물고기 종류(크기기준)가 있으면서 상어의 크기보다 작으면 먹을 수 있는 물고기 위치 배열에 추가 
				if(fishSize.size()!=0&&fishSize.get(0)<sharkSize) {
					while(fishSize.size()>0) {
						if(sharkSize<=fishSize.get(0)) {
							break;
						}
//						System.out.println("추가전 : "+position.size());
						position.addAll(fishs.get(fishSize.get(0)));
//						System.out.println("추가후 : "+position.size());
						fishSize.remove(0);
					}
				}
				if(position.size()==0) {
					break;
				}
				minLen= Integer.MAX_VALUE;
				int x = 0;
				int y = 0;
				int removeIdx = -1;
				int[][] moveCnt = bfs();
				
				// 가장 가까운 물고기 위치 찾기
				for(int i = 0;i<position.size();i++) {
					int[] temp = position.get(i);
					int len =  moveCnt[temp[0]][temp[1]];
					if(len == 0) {
						continue;
					}
					if(minLen>len) {
						minLen = len;
						x = temp[0];
						y = temp[1];
						removeIdx = i;
					}else if(minLen==len) {
						if(temp[0]<x) {
							x = temp[0];
							y = temp[1];
							removeIdx = i;
						}else if(temp[0]==x) {
							if(temp[1]<y) {
								x = temp[0];
								y = temp[1];
								removeIdx = i;
							}
						}
					}
				}
				if(removeIdx==-1) {
					break;
				}
				position.remove(removeIdx);
				
				map[x][y] = 0;
				shark[0] = x;
				shark[1] = y;
				time+=minLen;
				eatCnt++;
				if(eatCnt==sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}
			}
			
			System.out.println(time);
		}
	}
	
	static int[][] bfs() {
		int[][] moveCnt = new int[n][n];
		moveCnt[shark[0]][shark[1]] = -1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {shark[0],shark[1],0});
		while (!queue.isEmpty()) {
			int[] coordi = queue.poll();
			for (int i = 0; i < 4; i++) {
				int row = coordi[0] + dx[i];
				int col = coordi[1] + dy[i];
				if (!isBound(row, col)||moveCnt[row][col]!=0 ||map[row][col]>sharkSize) {
					continue;
				}
				moveCnt[row][col] = coordi[2]+1;
				queue.add(new int[] { row, col ,coordi[2]+1});
			}
		}
		
		return moveCnt;
	}
	

	static boolean isBound(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}
}
