package 정지안.week1;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// O(n) 혹은 O(n log n)으로 풀어야 한다.
// 즉, 2중 for문은 안된다.
public class BOJ_17298_오큰수구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 우에서 좌로 가며, stack에 추가한다.
        // 현재 arr 값이 stack.peek()보다 크면 while stack에서 꺼낸다.(큰게나올때까지.)
            // 다 꺼낼때까지 없으면, -1을 결과에 저장하고 본인을 스택에 넣는다.
            // 꺼내다가 중간에 큰게 있으면, 큰 값을 결과에 저장하고 본인을 스택에 넣는다.
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(stack.isEmpty()) {
                answer[i] = -1;
                stack.push(arr[i]);
                continue;
            }
            while(!stack.isEmpty()){
                int pop = stack.pop();
                if(pop<=arr[i]){//뽑은게 현재 값보다 같거나 작으면
                    continue; //뽑은채로 넘어간다.
                }else{//뽑은게 크면
                    answer[i] = pop;
                    stack.push(pop); //다시넣는다.
                    break;
                }
            }//while
            stack.push(arr[i]);

            if(answer[i] == 0){//끝내 초기화 안됐으면
                answer[i] = -1;
            }
        }//for

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
