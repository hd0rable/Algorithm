import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] s = new int[n][3]; //0 빨강 1 초록 2 파랑
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                s[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = s[0][0];
        dp[0][1] = s[0][1];
        dp[0][2] = s[0][2];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + s[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + s[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + s[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n-1][1],dp[n-1][2]),dp[n-1][0]));

    }
}