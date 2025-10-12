import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int nextPush = 1;
        for(int i=0 ; i<n; i++){
            int cmd = Integer.parseInt(br.readLine());
            while(nextPush<=cmd){
                stack.push(nextPush++);
                sb.append("+\n");
            }
            if(cmd != stack.peek()){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}