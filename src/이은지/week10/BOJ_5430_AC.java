package 이은지.week10;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	static int N;
	static Deque<Integer> dq;
	static boolean dir, error;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			dir = true;
			error = false;
			String command = br.readLine();
			int len = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			dq = new ArrayDeque<Integer>();

			for (int j = 0; j < len; j++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}

			for (int j = 0; j < command.length(); j++) {
				char a = command.charAt(j);

				if (a == 'D') {
					if (!dq.isEmpty()) {
						delete();
					} else {
						error = true;
						break;
					}
				} else if (a == 'R') {
					dir = !dir;
				}
			}

			if (error) {
				sb.append("error").append("\n");
				continue;
			}

			//출력
			sb.append("[");

			if (dir) {
				while(!dq.isEmpty()) {
					sb.append(dq.pollFirst());
					if (!dq.isEmpty()) sb.append(",");

				}
			} else {
				while(!dq.isEmpty()) {
					sb.append(dq.pollLast());
					if (!dq.isEmpty()) sb.append(",");
				}
			}

			sb.append("]").append("\n");

		}


		System.out.println(sb.toString());

	}

	private static void delete() {
		if (dir) { //앞에서부터
			dq.pollFirst();
		} else {
			dq.pollLast();
		}
	}

}
