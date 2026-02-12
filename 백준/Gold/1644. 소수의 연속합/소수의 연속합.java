import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체로 소수 판별
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i <=n; i++){
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int cnt = 0;
        int end = 0;
        int sum = 0;
        int size = primes.size();

        for(int st = 0; st <size; st++){

            while(end < size && sum < n) {
                sum += primes.get(end);
                end++;
            }

            if(sum == n) cnt++;
            sum -= primes.get(st);
        }
        System.out.println(cnt);
    }

}