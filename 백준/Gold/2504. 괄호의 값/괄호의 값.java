import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;
        char prev = ' ';
        for(char c : line.toCharArray()) {
            if(c == '('){
                stack.push(c);
                tmp *=2;
            }
            else if (c == '[') {
                stack.push(c);
                tmp *=3;
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                    if(prev == '(') result += tmp;
                    tmp/=2;
                }
                else if(!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    stack.pop();
                    if(prev == '[') result += tmp;
                    tmp/=3;
                }
                else { //괄호 짝이 안맞을때
                    result =0;
                    break;
                }
            }
            prev = c; //이전문자 저장
        }
        if(!stack.isEmpty()) result =0;
        System.out.println(result);
    }
}