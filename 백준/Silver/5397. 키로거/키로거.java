import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 강산이는 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        // 백스페이스 - 커서 바로앞에 글자 존재하면 그 글자 삭제
        // 화살표 <> 커서왼쪽 오른쪽 1만큼 움직임
        // 나머지 비밀번호 일부
        // 만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<L; i++){
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            String input = br.readLine();
            for(int j=0; j<input.length(); j++){
                char c = input.charAt(j);
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.addFirst(left.removeLast());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.addLast(right.removeFirst());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.removeLast();
                        break;
                    default:
                        left.addLast(c);
                        break;
                }
            }
            while (!left.isEmpty()) sb.append(left.removeFirst());
            while (!right.isEmpty()) sb.append(right.removeFirst());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}