import java.util.*;
import java.io.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int[] p : puddles)
           dp[p[1]-1][p[0]-1] = -1; //웅덩이 마킹
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;                 
                }
                if(i == 0 && j == 0) continue;
                int up   = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;
                dp[i][j] = (up + left) % 1000000007;
            }
        }

        return dp[n-1][m-1];
    }
}