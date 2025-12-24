import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] dp0 = new int[n+1];
            int[] dp1 = new int[n+1];

            dp0[0] = 1; dp1[0] = 0;
            if(n==0){
                sb.append(dp0[n]).append(' ').append(dp1[n]).append('\n');
                continue;
            }
            for(int i=1; i<=n; i++){
                dp0[i] = dp1[i-1];
                dp1[i] = dp0[i-1] + dp1[i-1];
            }
            sb.append(dp0[n]).append(' ').append(dp1[n]).append('\n');
        }
        System.out.println(sb);
    }
}