package 박경범;

import java.util.Scanner;

public class BOJ_2343_기타레슨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 강의 수
        int n = sc.nextInt();
        // 블루레이 수
        int m = sc.nextInt();
        
        int[] lessons = new int[n];
        int maxLessonLength = 0;
        int totalLength = 0;

        for (int i = 0; i < n; i++) {
            lessons[i] = sc.nextInt();
            if (lessons[i] > maxLessonLength) {
                maxLessonLength = lessons[i];
            }
            totalLength += lessons[i];
        }
        
        sc.close();
        
        // 이분 탐색 초기값 설정
        int low = maxLessonLength;
        int high = totalLength;
        int result = high;

        // 이분 탐색 시작
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDivide(lessons, n, m, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    // 주어진 크기(size)로 블루레이를 나눌 수 있는지 확인하는 함수
    public static boolean canDivide(int[] lessons, int n, int m, int size) {
        // 블루레이 개수
    	int count = 1;
    	// 블루레이 안에 들어가있는 영상의 길이
        int sum = 0;

        // size = 한 블루레이가 담을 수 있는 영상의 길이
        for (int i = 0; i < n; i++) {
        	// 만약 블루레이에 담을 수 있는 크기를 초과하면
            if (sum + lessons[i] > size) {
            	// 새로운 블루레이를 생성
                count++;
                sum = lessons[i];
                // 생성된 블루레이 개수가 문제에서 주어진 m 개의 블루레이 개수를 넘어가면 조건에 맞지 않음으로 false 반환
                if (count > m) {
                    return false;
                }
            // 블루레이 안에 영상을 담을 수 있다면 공간이 있다면 블루레이에 영상을 저장    
            } else {
                sum += lessons[i];
            }
        }

        return true;
    }
}
