import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1]; //i일째 되는 날까지 얻을수있는 최대 수익

        for(int i=0; i<n; i++){
            if(i + t[i] <= n) //상담하는 경우
                dp[i+t[i]] = Math.max(dp[i+t[i]],dp[i]+p[i]); //최대값 갱신
            dp[i+1] = Math.max(dp[i+1],dp[i]); //상담하지 않는 경우 다음날로 수익 반영하기
        }
        System.out.println(dp[n]);
    }
}