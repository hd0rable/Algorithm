import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int n = clothes.length;
        for(int i=0; i<n; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for(int cnt : map.values()){
            answer *= (cnt +1);
        }
        return answer-1; //아무것도 안입는 경우의 수 제외
    }
}