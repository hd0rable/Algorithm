import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String cmd = br.readLine();
            if(cmd.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            for(char c: cmd.toCharArray()){
                if(c == '(' || c=='[')
                    stack.push(c);
                if(c == ')' || c ==']'){
                    if(stack.isEmpty()) {
                        sb.append("no\n");
                        break;
                    }
                    if(stack.peek() == '(' && c == ')'
                            || stack.peek() == '[' && c == ']')
                        stack.pop();
                    else {
                        sb.append("no\n");
                        break;
                    }
                }
                if(c == '.'){
                    if(stack.isEmpty()) sb.append("yes\n");
                    else sb.append("no\n");
                }
            }
        }
        System.out.println(sb);
    }
}