import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length-1,j=0; i>=0&& j<citations.length; i--,j++){
            if(citations[i] < j+1)
                return j;
        }
        return citations.length;
    }
}