package 정지안.week1;

import java.io.*;
import java.util.Stack;

// =============== 문제 접근 ===============
// stack이 비어 있고, cnt가 num과 같다면 반복문 탈출
// stack이 비어 있고, cnt가 num보다 작다면 push
// stack이 비지 않고, stack.peek()가 num보다 작다면 push
// stack이 비지 않고, stack.peek()가 num과 같다면 pop
// stack이 비지 않고, stack.peek()가 num보다 크다면 "NO"
public class BOJ_1874_스택으로오름차순수열만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            while(true){
                if(stack.isEmpty() && cnt<=num){
                    stack.push(cnt++);
                    sb.append("+\n");
                }else if(!stack.isEmpty() && stack.peek()<num){
                    stack.push(cnt++);
                    sb.append("+\n");
                }else if(!stack.isEmpty() && stack.peek()==num){
                    stack.pop();
                    sb.append("-\n");
                    break;
                }else if(!stack.isEmpty() && stack.peek()>num){
                    bw.write("NO");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }

        }//for
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
