import java.io.*;
import java.util.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    static int[] state;
    static int[] arr;

    //BFS 연습
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            arr = new int[n+1];
            state = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=n; i++){
                if(state[i] == NOT_VISITED) run(i);
            }
            int count = 0;
            for(int i = 1; i <= n; i++){
                if(state[i] != CYCLE_IN) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void run(int x){
        int cur = x;
        while(true){
            state[cur] = x;
            cur = arr[cur];
            // 이전 방문에서 지나간 학생에 도달했을 경우
            if(state[cur] == x){
                while(state[cur] != CYCLE_IN){
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 지나간 학생에 도달했을 경우
            else if(state[cur] != 0) return;
        }

    }
}