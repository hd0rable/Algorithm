import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            solve(m,n,x,y);
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }

    static int lcm(int a, int b){
        return a / gcd(a,b)*b;
    }

    static void solve(int m, int n, int x, int y){
        if(x == m) x = 0;
        if(y == n) y = 0;
        int l = lcm(m,n);
        for(int i=x; i<=l; i+=m){
            if(i==0) continue;
            if(i%n ==y) {
                sb.append(i).append('\n');
                return;
            }
        }
        sb.append(-1).append('\n');
    }
}