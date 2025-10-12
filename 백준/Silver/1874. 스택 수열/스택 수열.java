import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i=0 ; i<n; i++){
            int cmd = Integer.parseInt(br.readLine());
            for(int j= flag+1; j<=cmd; j++){
                stack.push(j);
                sb.append("+").append("\n");
                if(j==cmd) flag = cmd; //스택에 마지막으로 넣은 수
            }
            if (cmd == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
            }
            else{
                sb.delete(0, sb.length());
                sb.append("NO").append("\n");
                break;
            }
        }
        System.out.println(sb);
    }
}