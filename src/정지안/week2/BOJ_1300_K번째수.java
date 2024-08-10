package 정지안.week2;

import java.io.*;

// ==================== 문제 접근 ====================
// 단순하게 모든 값을 계산하고 정렬하면 안풀릴 것이다. (골드1 문제이기 때문...)
// 그렇다면 조건을 파헤쳐 봤을 때, 왜 안풀릴까?
// N <= 100,000
// K <= 1,000,000,000 십 억.
// N제곱은 백억.
// 따라서 2중 for문으로 N을 계산하는 것은 100초의 시간이 필요하다. => 시간복잡도 충족X
// 모든 것을 계산하지 않고 규칙을 찾아야 한다.

// N = 3일 때, 아래 2차원 배열이 생긴다.
// 1 2 3
// 2 4 6
// 3 6 9

//이의 7번째 수는, 6이다.
//여기서 어떤 규칙을 찾을 수 있을까?

//k값이
// 1번쨰 = 1
// 2번째 = 2
// 3번째 = 2
// 4번째 = 3
// 5번째 = 3
// 6번째 = 4
// 7번째 = 6
// 8번째 = 6
// 9번째 = 9

// => 20분간 고민해 보았지만 규칙을 정의할 수 없었다.
// 따라서 다음 링크를 참고했다.(https://st-lab.tistory.com/281)

// 문제에서 구하고자하는 것은, B[k] = x 라는 x값.
// k는 배열에서 x보다 작거나 같은 원소들의 개수 합.
// n*n배열에서 x보다 작거나 같은 원소들의 개수 합은, 배열을 초기화 하지 않고도 구할 수 있다. => 구구단처럼 생각.
// 1~n 구구단에서 x보다 작은 개수는 1~n을 x에 나눠보면 알 수 있다.
// 이러한 구간 합을 counting하고, 카운팅한 결과가 k와 같다면 그것이 정답이다.
// 이러한 x값을 효율적으로 찾기 위해 이분 탐색을 사용한다.
public class BOJ_1300_K번째수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int lt = 1; //x의 최소값
        int rt = k; //x의 최대값. x는 k보다 클 수 없다.

        //이분 탐색
        while(lt<rt){
            long cnt = 0;
            int x = (lt+rt)/2; //x값은 최소와 최대의 중앙값.
            for(int i=1; i<=n; i++){
                cnt += Math.min(x / i, n);  // 올바른 수를 세기 위한 Math.min
            }

            if(cnt >= k){//세어진 수가 많다는 것은, x값이 너무크다는 소리니까
                rt = x; //최대값을 현재 x값으로 조정.
            }else if(cnt < k){
                lt = x+1;
            }
        }
        sb.append(lt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
