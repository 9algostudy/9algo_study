package 우성문.week15;

import java.io.*;
import java.util.*;

public class BOJ_1946_신입사원 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int T, n;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            list = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            int score = list.get(0)[1];
            for(int i=1; i<list.size(); i++)
            {
                if(list.get(i)[1] > score)
                    n--;
                else if(list.get(i)[1] < score)
                    score = list.get(i)[1];
            }
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}
