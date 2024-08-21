package 정지안.week3;

import java.io.*;
import java.util.PriorityQueue;

// ============== 문제 접근 ==============
//최소한 몇 번의 비교니까, PQ로 정렬하고 작은값부터 더해나가면되지않을까?

public class BOJ_1715_카드정렬하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }


        int sum = 0;

        int tmp = 0;
        while(pq.size()>1){
            tmp = pq.poll() + pq.poll(); //두 개 꺼내서 임시변수에 저장한다.
            sum += tmp; //이를 합에 합친다.
            pq.offer(tmp); // 다시 큐에 넣는다.
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }

}
