import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            int[] sub = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(sub);
            answer.add(sub[commands[i][2]-1]); 
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}