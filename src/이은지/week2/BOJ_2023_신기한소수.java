package 이은지.week2;

import java.io.*;

public class BOJ_2023_신기한소수 {
    static int N;
    static boolean[] prime;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        backTracking(0, N);
        System.out.println(sb);

    }

    private static void backTracking(int num, int count) {
        if (count == 0) {
            sb.append(num / 10).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isPrime(num + i)) {
                backTracking((num + i) * 10, count - 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
