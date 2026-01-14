//https://www.acmicpc.net/problem/9613
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            long ans = 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++)
                    ans += gcd(arr[i],arr[j]);
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
}