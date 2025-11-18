import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(pow(a,b,c));
    }

    static long pow(long a, long b, long m){
        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if(b==1) return a%m;
        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        long val = pow(a,b/2,m);

        /*
         * 현재 지수가 홀 수 였다면
         * A^(exponent / 2) * A^(exponent / 2) * A 이므로
         * A를 한 번 더 곱해주어야 한다.
         *
         * ex) A^9 = A^4 * A^4 * A
         */
        if(b%2==1) return (val*val%m)*a%m;
        return val*val%m;
    }
}