import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push" : stack.push(Integer.parseInt(st.nextToken())); break;
                case "pop" :
                    if(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n'); break;
                case "size" : sb.append(stack.size()).append('\n'); break;
                case "empty" :
                    if(stack.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append('\n'); break;
                case "top" :
                    if(!stack.isEmpty()){
                        sb.append(stack.peek());
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n'); break;
            }
        }
        System.out.println(sb);
    }
}
