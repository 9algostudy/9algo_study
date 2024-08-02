package 윤다은;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class BOJ_1940_주몽의명령 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int count = 0, sum;
		
		st = new StringTokenizer(br.readLine());
		
		int[] ingredients = new int[N];
		for (int i = 0; i < N; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ingredients);
		
		int i = 0, j = N-1;
		
		while (i < j) {
			sum = ingredients[i] + ingredients[j];
			if (sum == M) {
				count++;
				i++;
				j--;
			}
			else if (sum < M) {
				i++;
			}
			else {
				j--;
			}
		}
		
		System.out.println(count);
	}
	
//	public static void main(String[] args) throws IOException {
//	    int n = nextInt(), m = nextInt(), result = 0;
//	    Set<Integer> numbers = new HashSet<>(n / 2);
//	    for (int i = 0; i < n; i++) {
//	      int current = nextInt();
//	      if (numbers.contains(m - current)) {
//	        ++result;
//	        numbers.remove(m - current);
//	      } else {
//		        numbers.add(current);
//	      }
//	    }
//		System.out.println(result);
//	}	
}
