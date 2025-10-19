import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>(); // [값, 인덱스]

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 새로 들어오는 값보다 큰 값은 덱의 뒤에서 제거
            while(!deque.isEmpty() && deque.peekLast()[0] > num){
                deque.pollLast();
            }

            deque.addLast(new int[]{num,i});

            // 범위를 벗어난 값 제거
            if(deque.peekFirst()[1] <= i-L){
                deque.pollFirst();
            }

            // 현재 최촛값은 덱의 맨 앞
           sb.append(deque.peekFirst()[0]).append(' ');
        }
        System.out.println(sb);
    }
}