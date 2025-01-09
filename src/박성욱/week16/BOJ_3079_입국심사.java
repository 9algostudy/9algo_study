package 박성욱.week16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3079_입국심사 {
    static int n,m,max;
    static int [] arr;
    static int res;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        arr = new int[n];
        res = Integer.MAX_VALUE;
        max = 0;
        for(int i = 0; i <n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);

        solv();

        System.out.println(res);

    }

    private static void solv() {
        int left = 0;
        int right = m * max;
        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            for(int time: arr){
                sum += mid / time;
            }
            if(sum>=m){
                right = mid - 1;
                res = Math.min(res,mid);
            }
            else{
                left = mid + 1;
            }
        }
    }
}
