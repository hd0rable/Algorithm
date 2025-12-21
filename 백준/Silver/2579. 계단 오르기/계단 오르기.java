import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];

        int total = 0;
        for(int i=1; i<=n; i++) {
            score[i] = Integer.parseInt(br.readLine());
            total += score[i];
        }
        if(n<=2) {
            System.out.println(total);
            return;
        }

        int[] dp = new int[n+1]; //i번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, i번째 계단은 반드시 밟지 않을 계단으로 선택
        dp[1] = score[1];
        dp[2] = score[2];
        dp[3] = score[3];

        for (int i = 4; i <= n-1; i++)
            dp[i] = Math.min(dp[i-2],dp[i-3]) + score[i]; //i계단을 안밟을거면 i-2,i-3계단중 하나를 안밟아야함

        System.out.println(total - Math.min(dp[n-1],dp[n-2]));
        //마지막 도착계단은 반드시 밟아야하므로 n-1,n-2중에 최소인계단을 밟지않음
    }
}