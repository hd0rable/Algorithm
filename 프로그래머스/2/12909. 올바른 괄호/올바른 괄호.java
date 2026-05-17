import java.util.*;
class Solution {
    boolean solution(String s) {
        String[] st = s.split("");
        Deque<String> stack = new ArrayDeque<>();
        for(String string : st){
            if(string.equals("("))
                stack.push(string);
            else if(!stack.isEmpty() && stack.peek().equals("(") && string.equals(")"))
                stack.pop();
            else return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}