package 정지안.week1;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙구현하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Heap implements Comparable<Heap>{
        int num;

        public Heap(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Heap o) {
            if(num != o.num && Math.abs(num) == Math.abs(o.num)){//값은 다른데 절대값이 같으면
                return num - o.num; //작은수 출력
            }
            return Math.abs(num) - Math.abs(o.num);//절대값이 작은 값 출력
        }
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Heap> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int num =  Integer.parseInt(br.readLine());
            if(num!=0){
                pq.offer(new Heap(num));
            }else{//num이 0이면 출력
                if(pq.isEmpty()){//pq가 비었으면
                    sb.append("0\n");//0출력
                }else{//비어있지않으면
                    sb.append(pq.poll().num).append("\n"); // 꺼낸값출력
                }
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }

}
