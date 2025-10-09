import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        for(int i=1; i<=N; i++) {
            right.addLast(i);
        }

        int numm = 1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(count != N){
            if(numm>K) numm=1;
            if(right.isEmpty()){
                for(int i=0; i< left.size(); i++){
                    right.addLast(left.removeFirst());
                }
            }
            left.addLast(right.removeFirst());
            if(numm%K==0) {
                sb.append(left.removeLast());
                count++;
                if(count!=N) sb.append(", ");
            }
            numm++;
        }
        sb.append(">");
        System.out.println(sb);
    }
}