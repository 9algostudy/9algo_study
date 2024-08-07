package 정지안.week1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st  =new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int splitLen = Integer.parseInt(st.nextToken());
        char[] arr = new char[len];
        String A = br.readLine();
        for(int i=0; i<len; i++){
            arr[i] = A.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        int minA = Integer.parseInt(st.nextToken());
        int minC = Integer.parseInt(st.nextToken());
        int minG = Integer.parseInt(st.nextToken());
        int minT = Integer.parseInt(st.nextToken());

        int cnt=0;

        // ----------- 초기 부분 집합 세팅 -------------
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('C',0);
        map.put('G',0);
        map.put('T',0);
        for(int j=0; j<splitLen; j++){
            if(arr[j] == 'A') map.put('A',map.get('A')+1);
            else if(arr[j] == 'C') map.put('C',map.get('C')+1);
            else if(arr[j] == 'G') map.put('G',map.get('G')+1);
            else if(arr[j] == 'T') map.put('T',map.get('T')+1);
        }

        // -------------------------------------------
        int lt = 0;
        int rt = splitLen-1;

        while(rt<len){
            //조건을 충족했는가?
            if(map.get('A')>= minA &&
                    map.get('C')>=minC &&
                    map.get('G')>=minG &&
                    map.get('T')>=minT) cnt++;

            char ltChar = A.charAt(lt);
            if(ltChar == 'A') map.put('A', map.get('A')-1);
            else if(ltChar == 'C') map.put('C', map.get('C')-1);
            else if(ltChar == 'G') map.put('G', map.get('G')-1);
            else if(ltChar == 'T') map.put('T', map.get('T')-1);
            lt++;
            rt++;
            if(rt>=len) break;
            char rtChar = A.charAt(rt);
            if(rtChar == 'A') map.put('A', map.get('A')+1);
            else if(rtChar == 'C') map.put('C', map.get('C')+1);
            else if(rtChar == 'G') map.put('G', map.get('G')+1);
            else if(rtChar == 'T') map.put('T', map.get('T')+1);
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
