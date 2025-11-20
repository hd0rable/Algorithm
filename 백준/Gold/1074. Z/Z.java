import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(func(n,r,c));
    }

    static int func(int n, int r, int c){
        if(n==0) return 0;
        int half = (int)Math.pow(2,n-1); //한변의 길이의 절반
        if(r<half && c < half) return func(n-1,r,c); //1사분면
        if(r<half && c >= half) return half*half + func(n-1,r,c-half); //2사분면
        if(r>=half && c < half) return 2*half*half + func(n-1,r-half,c); //3사분면
        return 3*half*half + func(n-1,r-half,c-half); //4사분면
    }

}