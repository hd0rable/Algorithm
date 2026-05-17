import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int n : numbers) list.add(n);

        list.sort((a, b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            return (sb + sa).compareTo(sa + sb);
        });

        String answer = "";
        for(int i=0; i<list.size(); i++){
            answer += String.valueOf(list.get(i));
        }
        if(answer.startsWith("0")) answer = "0";
        return answer;
    }
}