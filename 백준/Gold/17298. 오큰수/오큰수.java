import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i]; //결과 배열에 해당 인덱스의 오큰수 저장
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1; //스택에 남은 인덱스들은 오큰수가없음
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(' ');
        }
        System.out.println(sb);

    }
}