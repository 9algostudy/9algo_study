package 우성문.week8;

import java.io.*;

public class Default{
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/우성문/week8/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
