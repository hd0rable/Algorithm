import java.io.*;
import java.util.*;

public class Main {

    static boolean[] state;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        state = new boolean[n+1];
        Arrays.fill(state, true);

        isPrime(n);

        for(int i=m; i<=n; i++){
            if(state[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    // 에라토스테네스의 체 풀이
    static void isPrime(int n){
        state[1] = false;
        for(int i=2; i*i<=n; i++){
            if(!state[i]) continue;
            for(int j = i*i; j<=n; j+=i)
                state[j] = false;
        }
    }

}