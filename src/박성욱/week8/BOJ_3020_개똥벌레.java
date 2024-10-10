package 박성욱.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str [] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] bottom = new int[n / 2];  
        int[] top = new int[n / 2];     
        
        for (int i = 0; i < n / 2; i++) {
            bottom[i] = Integer.parseInt(br.readLine()); 
            top[i] = Integer.parseInt(br.readLine());    
        }
        
        Arrays.sort(bottom);
        Arrays.sort(top);

        int mincnt = Integer.MAX_VALUE; 
        int rescnt = 0;  

        for (int i = 1; i <= m; i++) {
            int bottom_cnt = n / 2 - binarySearch(bottom, i); 
            int top_cnt = n / 2 - binarySearch(top, m - i + 1); 
            int total_cnt = bottom_cnt + top_cnt;

            if (total_cnt < mincnt) {
                mincnt = total_cnt;
                rescnt = 1;
            } else if (total_cnt == mincnt) {
                rescnt++;
            }
        }

        System.out.println(mincnt + " " + rescnt);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
