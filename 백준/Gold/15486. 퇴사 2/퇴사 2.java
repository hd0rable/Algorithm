import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; //i일째 되는 날까지 얻을수있는 최대 수익
        int max = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            max = Math.max(max, dp[i]);

            if(i+t <=n)
                dp[i+t] = Math.max(dp[i+t],max + p);

        }
        System.out.println(Math.max(max, dp[n]));
    }
}