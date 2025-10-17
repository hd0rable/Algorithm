import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //큐의 크기
        int M = Integer.parseInt(st.nextToken()); //뽑아 내려는 수의 개수

        int[] arr = new int[M];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=1; i<=N; i++){
            deque.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count =0;
        for (int i=0; i<M; i++) {
            int pop_idx = deque.indexOf(arr[i]);
            int half_idx;
            if(deque.size() % 2 == 0){
                half_idx = deque.size()/2 - 1;
            }else{
                half_idx = deque.size()/2;
            }

            while(deque.peekFirst() != arr[i]){
                // 중간보다 앞,중간에 있을경우 --> 앞에있는 원소 뒤로 보내기
                if(pop_idx <= half_idx) deque.addLast(deque.removeFirst());
                else deque.addFirst(deque.removeLast()); // 중간보다 뒤에있을 경우 --> 뒤에있는 원소 앞으로 보내기
                count++;
            }
            deque.removeFirst();
        }
        System.out.println(count);
    }
}