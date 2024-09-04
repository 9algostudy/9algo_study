package 이은지.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        for (int i = 0; i < n - 1; i++) {
            list.poll();
            int card = list.poll();
            list.add(card);
        }

        System.out.println(list.peek());


    }
}
