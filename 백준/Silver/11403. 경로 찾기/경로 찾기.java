//https://www.acmicpc.net/problem/11403
import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static boolean[] isVisited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        isVisited = new boolean[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(dfs(i,j)).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

    static int dfs(int st, int tar){
        isVisited = new boolean[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(st);
        while(!stk.isEmpty()){
            int cur = stk.pop();

            if(isVisited[cur]) continue;
            if(cur!=st) isVisited[cur] = true;

            for(int nxt = 0; nxt <n; nxt++){
                if(isVisited[nxt]) continue;
                if(arr[cur][nxt]==1) {
                    if(nxt == tar) return 1;
                    stk.push(nxt);
                }
            }
        }
        return 0;
    }
}
