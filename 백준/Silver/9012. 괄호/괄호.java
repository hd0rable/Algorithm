import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            String cmd = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c : cmd.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == '(' && c == ')'){
                        stack.pop();
                }
                else stack.push(c);
            }
            if(stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}