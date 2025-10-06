import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 커서를 기준으로 양방향 큐 두개로 나누기
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        // 초기문자열은 커서 왼쪽에 넣기
        for(char c: input.toCharArray()){
            left.addLast(c);
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    if(!left.isEmpty()) right.addFirst(left.removeLast());
                    break;
                case "D":
                    if(!right.isEmpty()) left.addLast(right.removeFirst());
                    break;
                case "B":
                    if(!left.isEmpty()) left.removeLast();
                    break;
                case "P":
                    left.addLast(st.nextToken().charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char c : left) sb.append(c);
        for(char c : right) sb.append(c);
        System.out.println(sb);
    }
}