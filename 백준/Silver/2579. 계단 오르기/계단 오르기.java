import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];

        for(int i=1; i<=n; i++)
            score[i] = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(score[1]);
            return;
        }

        int[][] dp = new int[n+1][2]; //j+1개의 계단을 연속으로 밟고 i번째 계단까지 올랐을때 점수합의 최댓값
        dp[1][0] = score[1]; dp[1][1] = 0;
        dp[2][0] = score[2]; dp[2][1] = score[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]) + score[i]; //1개의 계단으로 연속으로밟음 -> 전단계에서 건너뛰어밟음
            dp[i][1] = dp[i-1][0] + score[i]; //연속으로 계단을 밟음 -> 그전계단의 최댓값+
        }

        System.out.println(Math.max(dp[n][0],dp[n][1]));
    }
}