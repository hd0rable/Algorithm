import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // - 기준으로 먼저 나누기
        StringTokenizer str = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MIN_VALUE;
        while(str.hasMoreTokens()){
            int tmp = 0;
            StringTokenizer add = new StringTokenizer(str.nextToken(), "+");

            while(add.hasMoreTokens()){
                tmp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MIN_VALUE) sum = tmp;
            else sum -= tmp;
        }
        System.out.println(sum);
    }
}