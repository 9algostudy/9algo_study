package 이은지.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2342_DDR{

    static int[] now;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        now = new int[2]; //왼, 오
        dp = new int[5][5];

        for (String s : input.split("")) {
            if (s.equals("0")) {
                break;
            }

            int i = Integer.parseInt(s);

            command(i);

        }
    }

    private static void command(int n) {

    }

}
