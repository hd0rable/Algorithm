import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        for (int i = 0; i < T; i++) {
            char[] cmd = br.readLine().toCharArray(); // 명령어 입력
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for(int j = 0; j < N; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isFirst = true; //숫자 빼는 순서가 앞부터인지
            boolean error = false; // 에러 여부 체크
            for(char c : cmd){
                if(c == 'R'){
                    isFirst=!isFirst;
                    continue;
                }
                if(isFirst){
                    if(deque.pollFirst()==null){
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                }
                else{
                    if(deque.pollLast()==null){
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                }
            }
            if(error) continue;

            sb.append("[");
            while(!deque.isEmpty()){
                if(isFirst) sb.append(deque.removeFirst());
                else sb.append(deque.removeLast());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}