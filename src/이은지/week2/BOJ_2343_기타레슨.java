package 이은지.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {

    static int N, M;
    static int[] lecture;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N];

        int max = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            sum += lecture[i];
            if (max < lecture[i]) {
                max = lecture[i];
            }
        }

        System.out.println(binarySearch(max , sum));
    }

    private static int binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            int sum = 0;

            for(int i = 0; i < N; i++) {
                if (sum + lecture[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += lecture[i];
            }
            count++;

            if (count <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
