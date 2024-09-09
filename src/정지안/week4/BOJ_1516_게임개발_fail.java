package 정지안.week4;

import java.io.*;
import java.util.*;

// ============== 문제 접근 ==============
// (우선순위 큐 로직)
// 최소 요구가 적은 건물을 먼저 짓는다.
// 요구가 없다면, 바로 건물을 짓는다.
// 요구가 1개 이상이라면, 요구조건이 모두 충족된 건물을 짓는다.

// 위 로직대로 list에서 우선순위로 뽑아내다보면 모든 정답이 채워질 것이다.


public class BOJ_1516_게임개발_fail {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static Building[] buildingByNum; //번호 순서대로 빌딩 초기 정보를 저장
    static PriorityQueue<Building> pq = new PriorityQueue<>();

    static class Building implements Comparable<Building> {
        int num;
        int cost; // 해당 건물을 짓기 위한 비용
        Set<Integer> requiredBuildings = new HashSet<>(); // 해당 건물을 짓기 위해 요구되는 빌딩

        boolean[] visited;

        // 메서드1. 건물을 짓는데 필요한 총 비용
        public int getSumCost(){
            visited = new boolean[n+1];
            int sum = 0;
            // 계산에 필요한 빌딩넘버를 중복 없이 체크한다.
            Set<Integer> numSet = dfs(num,new HashSet<>()); //자 드가자

            for(int num:numSet){
                sum += buildingByNum[num].cost; // num 건물의 cost
            }

            return sum;
        }//getSumCost()

        // 메서드2. 빌딩 num의 set을 초기화하는 dfs
        public Set<Integer> dfs(int num, Set<Integer> set){
            if(visited[num]) return set; //이미방문했다면 return

            visited[num] = true;
            set.add(num); //현재 set에 빌딩숫자를 넣는다.
            Building building = buildingByNum[num]; //num번째 building에 대해
            //해당 빌딩의 요구 빌딩들을 찾아서 그 번호를 재귀적으로 set에 넣어준다.
            for(int requiredBuildingNum: building.requiredBuildings){
                set = dfs(requiredBuildingNum,set);
            }
            return set;
        }



        @Override
        public int compareTo(Building o) {
            // 1. 요구되는 빌딩이 적은 순서로 오름차순 정렬
            if(requiredBuildings.size() != o.requiredBuildings.size()) {
                return requiredBuildings.size()-o.requiredBuildings.size();
            }
            // 2. 요구되는 빌딩 개수가 같다면, '요구빌딩들의 비용정보를 모르는게 적은 순서대로 정렬'(결국 다 알아야 해당 빌딩의 최소 비용을 구할 수 있기 때문)
            // 비교군 1
            int cnt = 0;
            for(int requiredBuildingNum:requiredBuildings){
                if(buildingByNum[requiredBuildingNum].cost==0) cnt++; //모른다면 cnt++
            }
            //비교군 2
            int cntO = 0;
            for(int requiredBuildingNum:o.requiredBuildings){
                if(buildingByNum[requiredBuildingNum].cost==0) {
                    cntO++; //모른다면 cntO++
                }
            }

            return cnt-cntO;//요구빌딩들의 비용정보를 모르는게 적은 순서대로 오름차순
        }

        @Override
        public String toString(){
            return "["+num+"번 빌딩, 독자건설비용:"+cost +"]";
        }
    }



    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        buildingByNum = new Building[n+1];

        for(int i=1; i<=n; i++){ // 1~n번째 건물
            buildingByNum[i] = new Building(); // 빌딩 생성
            // ============= 0. 현재 건물 '번호' 및 '비용' 초기화 ========================
            buildingByNum[i].num = i; //현재 빌딩은 i번째 건물이다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            buildingByNum[i].cost = cost;

            // ============== 1. '요구건물' 추가 ==============================
            // 2번째부터 -1이 나올때까지 '요구 건물'을 추가한다.

            while(st.hasMoreTokens()){
                int requiredBuildingNum = Integer.parseInt(st.nextToken());
                if(requiredBuildingNum==-1) break;// -1이 나오면 멈춘다.

                // 선행이 필요한 요구 건물이 있다면 요구빌딩의 num을 빌딩의 set 변수에 추가
                buildingByNum[i].requiredBuildings.add(requiredBuildingNum);
            }
            // ================ 2. pq에 추가 ==============================
            pq.offer(buildingByNum[i]);

        }

        // ================= 3. pq를 순회하며 건물 확인 ====================
        int[] answer = new int[n+1];
        while(!pq.isEmpty()){
            Building building = pq.poll();
            //요구 건물의 모든 비용정보를 알고있다면
            if(isKnowAllCostBuildings(building)){
                //현재 건물을 짓기 위한 비용을 업데이트한다.
                answer[building.num] = building.getSumCost();
            }
        }


        for(int i=1; i<=n; i++){
            sb.append(answer[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }//main()


    // 현재 건물을 짓기 위한 요구 건물의 모든 비용정보를 알고 있는가?
    private static boolean isKnowAllCostBuildings(Building building) {
        //for문은 요구 건물이 없다면 돌아가지 않는다.
        for(int requiredBuildingNum:building.requiredBuildings){
            if(buildingByNum[requiredBuildingNum].cost == 0) return false; // 만약 하나라도 모르는 비용 정보가 있다면 false
        }
        return true; // 그게아니라면 true
    }
}
