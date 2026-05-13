class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n]; // 각 칸에서 가능한 최댓값
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){       
                if(j==0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if (i==j)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        int max = dp[n-1][0];
        for(int i=1; i<n; i++)
            max = Math.max(max,dp[n-1][i]); 
        
        return max;
    }
}