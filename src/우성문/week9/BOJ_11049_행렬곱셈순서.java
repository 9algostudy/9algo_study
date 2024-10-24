package 우성문.week9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_11049_행렬곱셈순서 {
	static int n;
	static int[][] matrixs; // 각 행렬의 행과 열 크기를 저장할 2차원 배열
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input/Baek_11049.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrixs = new int[n+1][2];
		dp = new int[n+1][n+1];
		String[] a;
		for(int i = 1; i <= n; i++) {
			a = br.readLine().split(" ");
			matrixs[i][0] = Integer.parseInt(a[0]);
			matrixs[i][1] = Integer.parseInt(a[1]);
		}
		dfs(1, n); // 1번 행렬부터 n번 행렬까지의 최소 곱셈 비용 계산
	    System.out.println(dp[1][n]);
	}
	
	static int dfs(int left, int right) {
        if (left == right - 1) // 인접한 두 행렬일 경우
            return dp[left][right] = matrixs[left][0] * matrixs[left][1] * matrixs[right][1]; // 곱셈 비용 계산 후 저장
        if (left == right) // 같은 행렬일 경우
            return dp[left][right] = 0; // 곱셈 비용은 0
        if (dp[left][right] != 0) // 이미 계산된 경우
            return dp[left][right]; // 저장된 값 반환
        dp[left][right] = Integer.MAX_VALUE; // 최소값을 찾기 위해 초기값 설정
        for (int i = left; i < right; i++) { // 분할하여 최적의 곱셈 순서 찾기
            // 현재의 최소 비용과 (left~i)와 (i+1~right) 부분 문제의 합, 그리고 해당 구간의 행렬 곱 비용을 비교
            dp[left][right] = Math.min(dfs(left, i) + dfs(i + 1, right) + matrixs[left][0] * matrixs[i][1] * matrixs[right][1], dp[left][right]);
        }
        return dp[left][right]; // 계산된 최소 비용 반환
    }
}
