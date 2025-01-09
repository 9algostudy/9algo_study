    package 이은지.week16;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class BOJ_3079_입국심사 {

        static int N;
        static long M, MAX, result;
        static int[] arr;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            result = Long.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                MAX = Math.max(arr[i], MAX);
            }

            Arrays.sort(arr);

            long left = 0;
            long right = M * MAX;

            while (left <= right) {
                long mid = (left + right) / 2;
                long total = 0;

                for (long idx : arr) {
                    long cnt = mid / idx;

                    if (total >= M) {
                        break;
                    }

                    total += cnt;
                }


                if (total >= M) {
                    right = mid - 1;
                    result = Math.min(mid, result);
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(result);
        }

    }
