package 우성문.week1;

import java.io.*;
import java.util.*;

public class BOJ_12891_DNA비밀번호 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().trim().split(" ");
		int s = Integer.parseInt(str[0]);
		int p = Integer.parseInt(str[1]);
		
		String line = br.readLine().trim();
		
		str = br.readLine().trim().split(" ");
		int a = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int g = Integer.parseInt(str[2]);
		int t = Integer.parseInt(str[3]);
		
		int cnt=0;
		int size = line.length();
		int[][] cntChar = new int[size+1][4];
		for(int i = 1;i<=size;i++) {
			switch (line.charAt(i-1)) {
			case 'A': {
				cntChar[i][0] = cntChar[i-1][0]+1;
				cntChar[i][1] = cntChar[i-1][1];
				cntChar[i][2] = cntChar[i-1][2];
				cntChar[i][3] = cntChar[i-1][3];
				break;
			}case 'C': {
				cntChar[i][0] = cntChar[i-1][0];
				cntChar[i][1] = cntChar[i-1][1]+1;
				cntChar[i][2] = cntChar[i-1][2];
				cntChar[i][3] = cntChar[i-1][3];
				break;
			}case 'G': {
				cntChar[i][0] = cntChar[i-1][0];
				cntChar[i][1] = cntChar[i-1][1];
				cntChar[i][2] = cntChar[i-1][2]+1;
				cntChar[i][3] = cntChar[i-1][3];
				break;
			}case 'T': {
				cntChar[i][0] = cntChar[i-1][0];
				cntChar[i][1] = cntChar[i-1][1];
				cntChar[i][2] = cntChar[i-1][2];
				cntChar[i][3] = cntChar[i-1][3]+1;
				break;
			}
			default:
				break;
			}
		}
		
		for(int i = p;i<=size;i++) {
			int aCnt = cntChar[i][0]-cntChar[i-p][0];
			int cCnt = cntChar[i][1]-cntChar[i-p][1];
			int gCnt = cntChar[i][2]-cntChar[i-p][2];
			int tCnt = cntChar[i][3]-cntChar[i-p][3];
			if(a<=aCnt&&c<=cCnt&&g<=gCnt&&t<=tCnt)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
