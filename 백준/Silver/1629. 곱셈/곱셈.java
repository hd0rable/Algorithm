import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b,c));
    }

    static long pow(long a, long b, long m){
        if(b==1) return a%m;
        long val = pow(a,b/2,m);
        val = val*val%m;
        if(b%2==0) return val;
        return val*a%m;
    }
}