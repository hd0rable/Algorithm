import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i= 0; i<N; i++){
            int num = i;
            int sum = 0; // 각 자릿수의 합

            while (num != 0){
                sum += num % 10; // 각 자릿수 더하기
                num /= 10;
            }

            // 각 자릿수 + 해당 수 == N (생성자를 찾았을 경우)
            if(sum + i == N)
            {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}