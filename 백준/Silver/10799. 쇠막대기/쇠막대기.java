import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char prev =' ';
        // 레이저면 앞괄호가 (
        // 바면 앞괄호가 )
        for(char c : cmd.toCharArray()){
            if(!stack.isEmpty() && stack.peek()=='(' && c ==')'){
                stack.pop();
                if(prev == '(') result += stack.size(); // 레이저일경우만 카운트 증가
                else result += 1; // 바일 경우 마지막 조각 카운트 증가
            }
            else stack.push(c);
            prev = c; //이전문자 저장
        }
        System.out.println(result);
    }
}