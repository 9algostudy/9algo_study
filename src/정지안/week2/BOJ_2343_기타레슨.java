package 정지안.week2;

import java.io.*;
import java.util.StringTokenizer;

// ============== 문제 접근 ==============
// 모든 경우를 탐색하는 n^m승 접근법은 안될듯.
// 20분정도 고민했는데 잘 모르겠다!
// => 알고리즘 책을 참고하여 정답을 도출.

// 해당문제를 통해 배운 점.
// 이분탐색의 low가 정답을 의미한다는 것을 리마인드.
// 이분탐색의 반복문 조건이 lt<=rt 라는 것을 리마인드.
// 이분탐색의 mid+1, mid-1 로 초기화 하는 것을 리마인드.

public class BOJ_2343_기타레슨 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int low = 0;//최소
        int high = 0;//최대
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low,arr[i]); //블루레이 길이의 최소값은 요소의 최댓값.
            high += arr[i];
        }

        while(low<=high){
            int mid = (low+high)/2;

            int cnt = 0;
            int tmpSum = 0;
            for(int i=0; i<n; i++){
                if(cnt>m){//블루레이 개수가 m보다 많아지면 현재 값을 더 큼직하게 키워야함.
                    break;
                }
                if (tmpSum + arr[i] > mid ){//현재 합계가 목표값보다 커지면 안됨!
                    cnt++;//블루레이 개수 증가
                    tmpSum = 0;
                }
                tmpSum += arr[i];
            }
            //탐색 이후 tmpSum이 0이 아니면 블루레이가 하나 더필요하다.
            if(tmpSum!=0) cnt++;

            if(cnt > m){
                low = mid+1;
            }else{ //현재 블루레이 개수 cnt가 목표 m보다 같거나 작으면
                high = mid-1;
            }
        }

        bw.write(low+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
