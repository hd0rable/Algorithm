import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>(); //유저아이디, 닉네임
        List<String> logs = new ArrayList<>(); //기록 저장
        for(String rc : record){
            String[] s = rc.split(" ");
            if(s[0].equals("Enter")){
                userMap.put(s[1],s[2]);
                logs.add(s[1] + "님이 들어왔습니다.");
            }
            else if(s[0].equals("Leave"))
                logs.add(s[1] + "님이 나갔습니다.");
            else
                userMap.put(s[1],s[2]);
        }
        
        String[] answer = new String[logs.size()];
        for(int i=0; i<logs.size(); i++){
            String log = logs.get(i);
            String uid = log.split("님이")[0];
            answer[i] = userMap.get(uid) + log.substring(uid.length());
        }
        return answer;
    }
}