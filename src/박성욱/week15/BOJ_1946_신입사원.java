package 박성욱.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1946_신입사원 {
    static class newguy implements Comparable<newguy> {
        int fir;
        int sec;

        public newguy(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }

        @Override
        public int compareTo(newguy o) {
            if (this.fir == o.fir) {
                return this.sec - o.sec;
            }
            return this.fir - o.fir;
        }
    }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int t = 1; t <= T; t++) {
                int n = Integer.parseInt(br.readLine());
                newguy[] arr = new newguy[n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int fir = Integer.parseInt(st.nextToken());
                    int sec = Integer.parseInt(st.nextToken());
                    arr[i] = new newguy(fir, sec);
                }
                Arrays.sort(arr);

                int cnt = 1;
                int firsec = arr[0].sec;
                for(int i =1;i<n;i++){
                    if(arr[i].sec < firsec){
                        cnt++;
                        firsec = arr[i].sec;
                    }
                }

                System.out.println(cnt);

            }

        }


    }

