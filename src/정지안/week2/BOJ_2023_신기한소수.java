package 정지안.week2;

import java.io.*;

// ================ 문제 접근 ================
// n자리의 모든 소수를 체크하는 방식은 옳은가? => n이 최대 8이므로, 10,000,000이고, 소수인지 판별하려면 그 안에서 루트 n만큼 또 for문을 돌리게된다.
// 따라서 시간복잡도 n * 루트n = 1,000,000,000,000 이므로 모든 소수를 체크하는 방식은 틀렸다.

// (오답)그렇다면, 루트 n까지 소수인지 아닌지 판별하고, dp를 통해 푸는건 어떨까? 풀어보자.

// 아이디어 참고 : https://st-lab.tistory.com/281
// 1의 자리수부터, 소수인 경우 그 다음 자리수에 숫자를 순회하며 소수인경우를 체크하는 방법이 있구나.


public class BOJ_2023_신기한소수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n= Integer.parseInt(br.readLine());

        dfs(0,n,new int[n]);


        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int n, int[] arr) throws IOException {
        if(depth == n){// 끝에 다다르면 출력
            for(int i=0; i<n; i++){
               bw.write(arr[i]+"");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=9; i++){
            int sum = 0;

            //1의자리 이외자리 연산!
            int ten = (int)Math.pow(10,depth);
            for(int j=0; j<depth; j++){
                sum += ten * arr[j];
                ten /= 10;
            }
            sum += i; //1의자리는 i!

            if(isSosu(sum)){//값이 소수라면
                arr[depth] = i;
                dfs(depth+1, n,arr);//다음dfs로
            }
        }

    }

    private static boolean isSosu(int num) {
        if(num<2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if((num % i) == 0) return false;
        }
        return true;
    }

}
