//https://www.acmicpc.net/problem/4948
import java.io.*;

public class Main {

    static final int max = 123456*2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isNotPrime = new boolean[max+1];
        for(int i=2; i*i <= max; i++){ //전범위에 대해 소수 찾기
            if(isNotPrime[i]) continue;
            for(int j=i*i; j<=max; j+=i){
                isNotPrime[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int cnt = 0;
            for(int i=n+1; i<=2*n; i++){
                if(!isNotPrime[i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}