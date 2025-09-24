import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // BufferedReader + 계수정렬(Counting Sort) + StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

       // 줄 수 입력
       int N = Integer.parseInt(br.readLine());

       // 범위 ~1000 <= input && input >=1000
        // arr[1000] == 0
       boolean[] arr = new boolean[2001];

       for (int i = 0; i < N; i++){
           arr[Integer.parseInt(br.readLine()) + 1000] = true;
       }

       // 정렬 과정이 따로 필요없음

        // 중복되는 수가 없으므로 각 인덱스에 맞는 숫자를 출력하면됨 O(N)
       // 출력
       for(int i=0 ; i< arr.length; i++){
           if(arr[i]){
               sb.append(i - 1000).append("\n");
           }
       }
        System.out.println(sb);
    }
}