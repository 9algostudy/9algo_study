package 우성문.week15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();

    static int l, c;
    static char[] alphabets;
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }
    static StringBuilder temp = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input/Baek_1759.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alphabets = br.readLine().replace(" ","").toCharArray();
        Arrays.sort(alphabets);

        dfs(0,0,0);
        System.out.println(sb);
    }

    static void dfs(int next, int consonantCnt, int vowelCnt){
        if(temp.length()==l){
            if(consonantCnt>1&&vowelCnt>0){
                sb.append(temp).append('\n');
            }
            return;
        }
        for(int i = next; i<c; i++){
            temp.append(alphabets[i]);
            if(set.contains(alphabets[i])){
                dfs(i+1, consonantCnt, vowelCnt+1);
            }
            else{
                dfs(i+1, consonantCnt+1, vowelCnt);
            }
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
