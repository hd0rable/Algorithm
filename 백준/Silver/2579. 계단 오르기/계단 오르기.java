import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];

        for(int i=1; i<=n; i++)
            score[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; //i번째 계단까지 올라섰을 때 점수합의 최댓값, i번째 계단은 반드시 밟아야함
        dp[1] = score[1];
        if(n>1) dp[2] = score[1] + score[2];
        if(n>2) dp[3] = Math.max(score[1],score[2]) + score[3];

        for (int i = 4; i <= n; i++)
            dp[i] = score[i] + Math.max(score[i-1]+dp[i-3],dp[i-2]);
        // 전 계단을 밟고 온 경우 score[i-1] + dp[i-3]
        // 전 계단을 밟지 않은 경우 dp[i-2]

        System.out.println(dp[n]);
    }
}