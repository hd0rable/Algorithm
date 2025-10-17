import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            queue.poll(); // 제일 위에 있는 카드 버리기
            queue.offer(queue.poll()); // 제일 위에있는 카드를 제일 아래에 있는 카드 밑으로 옮기기
        }
        System.out.println(queue.poll());
    }
}