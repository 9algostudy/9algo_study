package 우성문.week3;

import java.util.*;
import java.io.*;

public class BOJ_1931_회의실배정4 {
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("src/우성문/week3/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringBuilder sb = new StringBuilder();
    	
    	String[] line;
        int n = Integer.parseInt(br.readLine().trim());
        List<int[]> meetings = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	line = br.readLine().trim().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            meetings.add(new int[] {start,end});
        }
        
        Collections.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int count = 0;
        int lastEndTime = -1;
        
        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEndTime) {
                count++;
                lastEndTime = meeting[1];
            }
        }
        
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
}
