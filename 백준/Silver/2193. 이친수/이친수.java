import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][2];
        dp[1][0] = 0; // 0으로끝나는 숫자의 개수
        dp[1][1] = 1; // 1로 끝나는 숫자의 개수

        for(int i=2; i<=n; i++){
            long cnt0 = dp[i-1][0];
            long cnt1 = dp[i-1][1];
            dp[i][0] = cnt0 + cnt1;
            dp[i][1] = cnt0;
        }
        System.out.println(dp[n][0]+dp[n][1]);
    }

}