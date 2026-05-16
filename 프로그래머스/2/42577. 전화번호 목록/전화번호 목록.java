import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for(String phone : phone_book){
            for(int i=1; i<phone.length(); i++){
                if(set.contains(phone.substring(0,i))) return false; //각 번호의 접두어가 set에 있는지 확인
            }
        }
        return true;
    }
}