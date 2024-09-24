package 박성욱.week6;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844_쉬운계단수{
    static Long dp[][];
    static long sum = 0;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n+1][10];

        dp[1][0]=0L;
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1L;
        }

        for(int i=0; i<=9; i++) {
            sum += num(n, i) % 1000000000;
            sum %= 1000000000;
        }
        System.out.println(sum);

    }
    public static long num(int n, int d) {
        if(n==1) return dp[n][d];

        if(dp[n][d] == null) {
            if(d==0) {
                dp[n][d] = num(n-1, d+1);
            } else if(d==9) {
                dp[n][d] = num(n-1, d-1);
            } else {
                dp[n][d] = num(n-1, d-1) + num(n-1, d+1);
            }
        }

        return dp[n][d] % 1000000000;
    }
}


