import java.io.*;
import java.util.*;

public class Main {

    static int[][] triangle;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new Integer[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
                if(i == n-1) dp[i][j] = triangle[i][j]; //가장 마지막 행값들 dp에 복사
            }
        }
        System.out.println(find(0,0));
    }

    static int find(int depth, int idx){
        if(depth == n-1) return dp[depth][idx];

        //탐색하지 않았던 경우만
        if(dp[depth][idx] == null)
            dp[depth][idx] = Math.max(find(depth+1,idx), find(depth+1,idx+1)) + triangle[depth][idx];

        return dp[depth][idx];
    }
}