package 우성문.week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_2166_다각형의면적 {
	static int n;
	static long[][] node;
	static long areaSum;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/input/Baek_2166.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a;
 		
		n = Integer.parseInt(br.readLine());
		node = new long[n][2];
		for(int i = 0;i<n;i++) {
			a = br.readLine().split(" ");
			node[i][0] = Integer.parseInt(a[0]);
			node[i][1] = Integer.parseInt(a[1]);
		}
		
		areaSum = determinant(node[n-1], node[0]);
		
		for(int i = 0;i<n-1;i++) {
			areaSum += determinant(node[i], node[i+1]);
		}
		System.out.println(String.format("%.1f", Math.abs(areaSum/2.0)));
	}
	
	
	// 행렬식 이용 : https://ko.wikipedia.org/wiki/%ED%96%89%EB%A0%AC%EC%8B%9D
	static long determinant(long[]a ,long[]b) {
		return a[0]*b[1]-a[1]*b[0];
	}
}
