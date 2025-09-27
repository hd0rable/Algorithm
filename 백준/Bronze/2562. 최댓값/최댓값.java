import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 9;
        int max = 0; //최댓값
        int flag = 10; //최댓값 위치
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) { //최댓값 업데이트
                max = arr[i];
                flag = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[flag]).append("\n").append(flag+1);
        System.out.println(sb);
    }
}