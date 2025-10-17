import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //큐의 크기
        int M = Integer.parseInt(st.nextToken()); //뽑아 내려는 수의 개수

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            deque.addLast(i);
        }

        int min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int count1 = 0; int count2 = 0;
            int pop = Integer.parseInt(st.nextToken());
            boolean isFirst = true;

            Deque<Integer> deque1 = new ArrayDeque<>(deque);
            Deque<Integer> deque2 = new ArrayDeque<>(deque);
            while(deque1.peekFirst() != pop) {
                deque1.addFirst(deque1.removeLast());
                count1++;
            }
            while(deque2.peekFirst() != pop) {
                deque2.addLast(deque2.removeFirst());
                count2++;
                isFirst = false;
            }
            min += Math.min(count1, count2);
            if(isFirst) {
                deque1.removeFirst();
                deque = deque1;
            }
            else {
                deque2.removeFirst();
                deque = deque2;
            }
        }
        System.out.println(min);
    }
}