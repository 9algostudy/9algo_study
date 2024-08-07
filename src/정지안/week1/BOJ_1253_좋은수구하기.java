package 정지안.week1;

import java.io.*;
import java.util.*;

// =============== 문제 사고 과정 ===============
// N이 2000개.
// dfs로 풀면 시간 초과
// n^2 이나 n log n 으로 풀어야하는데

//(오답)2중 for문으로 dp를 만들고, 마지막에 배열을 순회하며 해당숫자가 있다면 cnt를 늘리자.

//(오답)=> 메모리초과가 났다. Set을 통해 해결해보자.

// => 이젠 틀렸습니다가 뜨는데 예외가 뭘까?

// => 문제에 설명이 부족함. 자기자신을 제외한 나머지 숫자를 더했을 때, 자기자신이되는 숫자를 찾아야 하는 문제.
//(60% 오답) 0은 더하면안된다. 그럼 자기자신이 나올테니까.

//0이 3개 이상이라면 0도 set에 더해야한다.
//(성공) map.get(0)을 => map.getOrDefault(sum,0)>=3 으로 바꿈



public class BOJ_1253_좋은수구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        // 1. 배열 초기화
        Map<Integer,Integer> map = new HashMap<>(); // 이따 나올 sum을 바로 꺼내기 위한 map!
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        // 2. 모든 합 경우의수 체크
        Set<Integer> set  = new HashSet<>();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int sum =  arr[i]+arr[j];

                if(arr[i]==0 && arr[j]==0){
                    if(map.getOrDefault(sum,0)>=3){
                        set.add(sum);
                    }
                }else if(arr[i]==0 || arr[j]==0){
                    if(map.getOrDefault(sum,0)>=2){
                        set.add(sum);
                    }
                }else{
                    set.add(sum);
                }

            }//for-2
        }//for-1

        // 3.arr를 순회하며 양수,음수별로 set에 값이 있는지 체크
        int cnt=0;
        for(int i=0; i<n; i++){
            if(set.contains(arr[i])){//set에 원소가 있고,
                 cnt++; //sum에 본인이 포함되지 않은 경우만 cnt ++
            }
        }

        //결과값 출력
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
