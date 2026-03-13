import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(n); //최소 힙

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
                if(pq.size() > n) //큐 크기 유지
                    pq.poll(); //가장 작은 숫자 버리기
            }
        }
        System.out.print(pq.peek());
    }
}
