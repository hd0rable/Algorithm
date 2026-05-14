import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            // 가격이 떨어지는 시점에 스택에서 꺼내서 시간 계산
            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                int idx = st.pop();
                answer[idx] = i - idx;// 떨어진 시점 - 시작 시점
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int idx = st.pop();
            answer[idx] = n-1-idx;
        }
        return answer;
    }
}