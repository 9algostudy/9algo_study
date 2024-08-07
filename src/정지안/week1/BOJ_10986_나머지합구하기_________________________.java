package 정지안.week1;

// ================ 문제 접근 ================
/*
* int[] sum
*
* 15~20분 고민 => GPT
* 뭔소린지모르겠는데?
*
* */


import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합구하기_________________________ {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr =new int[n];
        int[] sum = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = arr[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1]+arr[i];
        }


    }

}
