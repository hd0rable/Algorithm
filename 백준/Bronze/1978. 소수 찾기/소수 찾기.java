import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while(n-- > 0){
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = isPrime(num);
            if(isPrime) cnt++;
        }
        System.out.println(cnt);
    }

    static boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i * i <=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}