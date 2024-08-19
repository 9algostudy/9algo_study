package 정지안.week2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            int answer = map.getOrDefault(num,0);
            if(answer >= 1){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
