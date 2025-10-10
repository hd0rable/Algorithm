import java.io.*;
import java.util.*;

public class Main {

    //스택 직접 구현
    static int[] stack = new int[10000];
    static int pos = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push" : push(Integer.parseInt(st.nextToken())); break;
                case "pop" : sb.append(pop()).append('\n'); break;
                case "size" : sb.append(size()).append('\n'); break;
                case "empty" : sb.append(empty()).append('\n'); break;
                case "top" : sb.append(top()).append('\n'); break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num){
        stack[pos++] = num;
    }

    public static int pop(){
        if(pos == 0) return -1;
        return stack[--pos];
    }

    public static int size(){
        return pos;
    }

    public static int empty(){
        if (pos ==0)return 1;
        return 0;
    }

    public static int top(){
        if(pos == 0) return -1;
        return stack[pos-1];
    }
}