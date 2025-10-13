import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // int[]: [탑번호, 탑높이]
        Stack<int []> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 스택에서 현재 탑보다 낮은 탑 전부 제거
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[]{i, height});
        }

        System.out.println(sb);
    }
}