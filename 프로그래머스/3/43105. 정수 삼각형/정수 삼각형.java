class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n]; // 각 칸에서 가능한 최댓값
        
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            for(int j=1; j<i; j++){       
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        int max = dp[n-1][0];
        for(int i=1; i<n; i++)
            max = Math.max(max,dp[n-1][i]); 
        
        return max;
    }
}