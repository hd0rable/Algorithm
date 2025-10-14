import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            // i번째 빌딩보다 낮거나 같은 뺀다
            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            sum += stack.size(); //스택에는 해당 빌딩에서 관찰가능한 빌딩의 높이가 저장되어있음
            stack.push(height); //i번째 빌딩의 높이를 넣는다
        }
        System.out.println(sum);
    }
}