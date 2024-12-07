package 우성문;

import java.io.*;
import java.util.*;

public class Init {
    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/우성문/input/"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //st.nextToken()
    }
}
