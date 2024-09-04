package 이은지.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

    static int N, d, k, c;
    static int[] arr, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        count = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k - 1;
        int max = 1; // 쿠폰 때문에 1부터 시작
        count[c]++;

        for (int i = start; i <= end; i++) {
            if (count[arr[i]] == 0) {
                max++;
            }
            count[arr[i]]++;
        }

        int cnt = max;
        for (int i = 0; i < N; i++) {
            int a = arr[i]; // 빠지는 접시
            int b = arr[(i + k) % N]; // 추가되는 접시

            if (count[a] == 1) { //a가 하나면 가짓수가 줄어듦
                cnt--;
            }
            count[a]--;

            if (count[b] == 0) { // b가 0이면 가짓수가 증가
                cnt++;
            }
            count[b]++;

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }

}
