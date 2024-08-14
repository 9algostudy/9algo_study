package 박경범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2309_일곱난쟁이 {
	static List<Integer> list;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		arr = new int[2];

		backTracking(0, 1);
	}

	static void backTracking(int depth, int start) {
		if(depth == 2) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for(int i = start; i < 3; i++) {
			arr[depth] = i;
			backTracking(depth+1 , i);
		}
	}
}


