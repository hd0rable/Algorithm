import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String prev = s.substring(0,i); //첫 조각
            int cnt = 1;
            String result = "";
            
            for(int j=i; j<s.length(); j+=i){
                String cur = s.substring(j,Math.min(j+i,s.length()));
                if(cur.equals(prev))
                    cnt++;
                else{
                    result += (cnt > 1 ? cnt : "") + prev; // cnt가 1이면 숫자 생략
                    prev = cur;
                    cnt = 1;
                }
            }
            result += (cnt > 1 ? cnt : "") + prev;  // 마지막 조각 처리
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}