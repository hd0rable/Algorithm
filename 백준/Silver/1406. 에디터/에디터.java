import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());

        // 커서를 기준으로 스택 두개로 나누기
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 초기문자열은 커서 왼쪽에 넣기
        for(char c: input.toCharArray()){
            left.push(c);
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    if(!left.empty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.empty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.empty()) left.pop();
                    break;
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        //왼쪽 스택에 있는 애들 출력하기위해 뒤집기
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);
    }
}