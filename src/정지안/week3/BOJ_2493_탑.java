package 정지안.week3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// ============= 문제 접근 =============
// 문제조건 : 탑의 높이는 1억. 탑의 수 n은 500,000. n^2은 250,000,000,000. 따라서 시간복잡도 O(nlogn)으로 해결해야 한다.
// 즉, 하나하나 확인하는 방식은 안된다는 말.

// 6 9 5 7 4

//     ㅁ
//     ㅁ
//     ㅁ        ㅁ
//  ㅁ ㅁ        ㅁ
//  ㅁ ㅁ   ㅁ   ㅁ
//  ㅁ ㅁ   ㅁ   ㅁ   ㅁ
//  ㅁ ㅁ   ㅁ   ㅁ   ㅁ
//  ㅁ ㅁ   ㅁ   ㅁ   ㅁ
//  ㅁ ㅁ   ㅁ   ㅁ   ㅁ

// 왼쪽부터 진행해야할까, 오른쪽부터 진행해야 할까?
// 하나하나 확인하는방식이 아니라면 어떤방식이있을까?

//(보류)
// 탑이 1로 구성된 비트라고 했을 때, 비트연산으로 해결할 수 있을까?
// 기본 구상 : 우측부터 관측해야하며, & 연산 결과가 관측한 현재 탑과 같으면 된다.
// 1. 맵을 통해 비트를 키 값으로 저장한다.(나중에 꺼내기 위함)
// 2.

//(오답:시간초과.) 의외로간단한가? 그냥 오른쪽으로부터 인덱스줄이면서 체크하면되나?=> 왜시간초과가나는지 파악필요
/*
int[] answer = new int[n];
for(int i=n-1; i>=0; i--){
    int current = arr[i];
    for(int j=i-1; j>=0; j--){
        int top = arr[j];
        if(top>current){
            answer[i] = j+1;
            break;
        }
    }
}
* */





public class BOJ_2493_탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n  =Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> map  =new HashMap<>();
        map.put(0,0); // 정답에 0이라고 저장한 경우, 0 그대로 출력.

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i+1); //값에 대한 인덱스를 반환하는 맵
        }
        Stack<Integer> stack  = new Stack<>();// Stack을 통해 탑을 순서대로 쌓아나가고,
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){//스택이 비어있다면
                answer[i] = 0; // 레이저는 어떤 탑에도 닿지 않는다.
            }else{//스택이 비어있지 않은 경우
                //필요없는 스택을 제거한다.(필요없는스택 = 현재 탑의 높이보다 작은 것)
                while(!stack.isEmpty() && stack.peek()<arr[i]){//스택이 비어있지 않고, 스택의 맨위를 봤을 때 현재 탑보다 작다면
                    stack.pop(); //스택의 요소를 제거한다.
                }
                //필요없는 스택을 제거하고 난뒤
                if(stack.isEmpty()){//비어있다면
                    answer[i] = 0; // 정답은 0
                }else{//비어있지 않다면
                    answer[i] = stack.peek(); //맨위를 바라본 값
                }
            }
            stack.push(arr[i]);//현재 탑을 추가한다.
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(map.get(answer[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }//main

}//Class
