import java.io.*;
import java.util.*;

public class Main {

    public static int[] queue = new int[2000000];
    public static int head = 0;
    public static int tail = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb  = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken())); break;
                case "pop":
                    sb.append(pop()).append("\n"); break;
                case "size":
                    sb.append(size()).append("\n"); break;
                case "empty":
                    sb.append(empty()).append("\n"); break;
                case "front":
                    sb.append(front()).append("\n"); break;
                case "back":
                    sb.append(back()).append("\n"); break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num){
        queue[tail++] = num;
    }

    public static int pop(){
        if (head == tail)  return -1;
        return queue[head++];
    }

    public static int size(){
        return tail - head;
    }

    public static int empty(){
        if(size() == 0) return 1;
        else return 0;
    }

    public static int front(){
        if(head == tail)  return -1;
        return queue[head];
    }

    public static int back(){
        if(head == tail)  return -1;
        return queue[tail-1];
    }
}