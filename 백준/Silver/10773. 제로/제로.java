import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0){
                sum -= stack.pop();
                continue;
            }
            stack.push(cmd);
            sum += stack.peek();
        }
        System.out.println(sum);
    }
}