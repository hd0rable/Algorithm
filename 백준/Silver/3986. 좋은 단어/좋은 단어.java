import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N-- > 0){
            String cmd = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c : cmd.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                else stack.push(c);
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}