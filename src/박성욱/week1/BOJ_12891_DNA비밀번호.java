package 박성욱.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12891_DNA비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nmarr = br.readLine().trim().split(" ");
		int n = Integer.parseInt(nmarr[0]);
		int m = Integer.parseInt(nmarr[1]);
		
		String [] arr = br.readLine().split("");
		
		String [] numarr = br.readLine().split(" ");
		int Acnt = Integer.parseInt(numarr[0]);
		int Ccnt = Integer.parseInt(numarr[1]);
		int Gcnt = Integer.parseInt(numarr[2]);
		int Tcnt = Integer.parseInt(numarr[3]);
		
		int arrcnt = 0;
		
		for(int t = 0;t<arr.length-m + 1;t++) {
			int A = 0;
			int C = 0;
			int G = 0;
			int T = 0;
			for(int i = t;i<t+m;i++) {
				switch(arr[i]) {
					case "A": A++; break;
					case "C": C++; break;
					case "G": G++; break;
					case "T": T++; break;
					}
				if(A >= Acnt && C>= Ccnt && G>= Gcnt && T>= Tcnt)
					arrcnt++;
			}
			}
		System.out.println(arrcnt);
		
		}
			
	}

