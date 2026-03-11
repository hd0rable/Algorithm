import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) ->{
            if(Math.abs(a) == Math.abs(b))
                return a-b; //절댓값이 같으면 실제 값이 작은순
            return Math.abs(a) - Math.abs(b); // 절댓값이 작은 순
        });

        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(absHeap.isEmpty()) sb.append(0).append('\n');
                else sb.append(absHeap.poll()).append('\n');
            }
            else absHeap.add(x);
        }
        System.out.println(sb);
    }
}
