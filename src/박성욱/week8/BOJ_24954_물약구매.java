package 박성욱.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24954_물약구매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] price = new int[N + 1];
        String[] pricearr = br.readLine().trim().split(" ");
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(pricearr[i - 1]); 
        }

        int[][] sale = new int[N + 1][N + 1]; 
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                String[] salestr = br.readLine().trim().split(" ");
                int saleidx = Integer.parseInt(salestr[0]);
                int saleprice = Integer.parseInt(salestr[1]);
                sale[i][saleidx] = saleprice; 
            }
        }
        
    }
}
