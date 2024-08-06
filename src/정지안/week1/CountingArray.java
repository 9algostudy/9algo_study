package 정지안.week1;

import java.util.Arrays;

public class CountingArray {

    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,6,7,22,10,2,1};

        int[] countingArr = countingArr(arr);

        System.out.println(Arrays.toString(countingArr));
    }

    private static int[] countingArr(int[] arr) {
        // 1. 최소값,최대값 판별
        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        for(int i=0; i<n; i++){
            if(min>arr[i]) min = arr[i];
            if(max<arr[i]) max = arr[i];
        }
        
        // 2. 카운팅 배열 생성
        int[] count = new int[max - min + 1];
        
        // 3. 누적합 계산
        for(int i=0; i<n; i++){
            count[arr[i]-min]++;
        }
        
        // 4. arr초기화
        int idx = 0;
        for(int i=0; i<max-min+1; i++){
            while(count[i]>0){
                arr[idx++] = i+min;
                count[i]--;
            }
        }

        return arr;
    }


}
