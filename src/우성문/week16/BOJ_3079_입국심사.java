package 우성문.week16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이분 탐색 사용
 * 주어진 시간안에 주어진 인구 전체 입국 심사 받을 수 있는 지
 * 연산하는 과정에서 오버플로우 발생
 * how? [1,1,...,큰수] => 큰수+큰수+...+1 = 오버플로우
 */
public class BOJ_3079_입국심사 {
    static StringTokenizer st;
    static BufferedReader br;

    static int n, max=0;
    static long m, left=1, right;;
    static int[] times;
    static long result=Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_3079Baek_3079.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }
        right = max*m;

        while(left<=right){
            long mid = (left+right+1)/2;
            long total = totalNum(mid);
            if(total>=m){
                result=Math.min(result,mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(result);
    }

    static long totalNum(long flag){
        long total = 0;
        for(int i = 0;i<n;i++){
            total += flag/times[i];
            if(total>=m){
                return m;
            }
        }
        return total;
    }
}