package 정지안.week3;
//
//import java.io.*;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//// ============ 문제 접근 ============
//// (오답)회의 시간이 가장 짧은것 순서대로 채워나가면 정답일것같은데
//// => 회의 끝시간이 빨리끝나는것부터 처리. 똑같이 빨리끝난다면 빨리시작하는것부터.
//public class BOJ_1931_회의실배정 {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static int[]arr;
//
//    static class Meeting implements  Comparable<Meeting>{
//        int start;
//        int end;
//        int sub;
//
//        public Meeting(int start,int end){
//            this.start = start;
//            this.end = end;
//            this.sub = end - start;
//        }
//
//        @Override
//        public int compareTo(Meeting o) {
//            if(end!=o.end) return end - o.end;
//
//            return start-o.start;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        int n = Integer.parseInt(br.readLine());
//        arr= new int[100001];
//        PriorityQueue<Meeting> pq = new PriorityQueue<>();
//        for(int i=0; i<n; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());//회의 시작시간
//            int end = Integer.parseInt(st.nextToken());//회의 끝시간
//
//            pq.offer(new Meeting(start,end));
//        }
//
//
//        int cnt = 0;
//        int lastEnd = -1;
//        while(!pq.isEmpty()){
//            Meeting current = pq.poll();// 짧은 미팅시간의 미팅을 꺼내서,
//            //배치할 수 있으면 배치한다.
//
//            if(current.start >= lastEnd){
//                cnt++;
//                lastEnd = current.end;
//            }
//        }
//
//        bw.write(cnt+"\n");
//        bw.flush();
//        bw.close();
//        br.close();
//
//
//    }
//
//}

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ============ 문제 접근 ============
// (오답)회의 시간이 가장 짧은것 순서대로 채워나가면 정답일것같은데
// => 회의 끝시간이 빨리끝나는것부터 처리. 똑같이 빨리끝난다면 빨리시작하는것부터.
public class BOJ_1931_회의실배정 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[]arr;

    static class Meeting implements  Comparable<Meeting>{
        int start;
        int end;
        int sub;

        public Meeting(int start,int end){
            this.start = start;
            this.end = end;
            this.sub = end - start;
        }

        @Override
        public int compareTo(Meeting o) {
            if(end!=o.end) return end - o.end;

            return start-o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr= new int[100001];
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//회의 시작시간
            int end = Integer.parseInt(st.nextToken());//회의 끝시간

            pq.offer(new Meeting(start,end));
        }


        int cnt = 0;
        while(!pq.isEmpty()){
            Meeting current = pq.poll();// 짧은 미팅시간의 미팅을 꺼내서,
            //배치할 수 있으면 배치한다.
            if(isEmptyTime(current.start, current.end)){
                fillTime(current.start,current.end);
                cnt++;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();


    }

    private static void fillTime(int start, int end) {
        for(int i=start; i<end; i++){
            arr[i] = 1; //회의 진행중 상태로 변경
        }


    }

    private static boolean isEmptyTime(int start, int end) {
        for(int i=start; i<end; i++){
            if(arr[i]==1) return false;
        }
        return true;
    }

}
