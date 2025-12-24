import java.io.*;
import java.util.*;

public class Main {

    static int[][] triangle;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                if(j==0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j==i)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }
        int max = -1;
        for(int i=0; i<n; i++)
            max = Math.max(max,dp[n-1][i]);
        
        System.out.println(max);
    }

}