import java.io.*;
import java.util.*;
class Solution {
    public int solution(int N, int number) {
        
        // dp[i] = N을 i번 써서 만들 수 있는 숫자 집합
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<>();
            
            // 연결숫자
            int concat = 0;
            for (int j = 0; j < i; j++) {
                concat = concat * 10 + N;
            }
            set.add(concat);


            for(int j=1; j<i; j++){
                for(int a: dp.get(j)){
                    for(int b : dp.get(i-j)){
                        set.add(a+b);
                        set.add(a-b);
                        set.add(a*b);
                        if(b!=0) set.add(a/b);
                    }
                }
            }
            if(set.contains(number)) return i;
            dp.add(set);
        }
        return -1;
    }
}