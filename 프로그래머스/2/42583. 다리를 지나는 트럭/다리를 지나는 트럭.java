import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int n = truck_weights.length;
        int answer = 0;
        // 다리를 0으로 채워서 초기화
        for (int i = 0; i < bridge_length; i++) bridge.offer(0);

        int currentWeight = 0;  // 다리 위 현재 무게 합
        int truckIdx = 0;       // 다음 올릴 트럭 인덱스

        while (truckIdx < n || currentWeight > 0) {
            currentWeight -= bridge.poll();

            if(truckIdx < n &&  currentWeight + truck_weights[truckIdx] <= weight){
                bridge.offer(truck_weights[truckIdx]);
                currentWeight += truck_weights[truckIdx];
                truckIdx++;
            }else {
                bridge.offer(0);
            }
            answer++; //초 카운팅
        }
        return answer;
    }
}