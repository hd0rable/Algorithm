import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader + Arrays.sort + StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

       // 줄 수 입력
       int length = Integer.parseInt(br.readLine());

        // 정수 해당 줄만큼 입력
        int [] list = new int [length];
       for (int i = 0; i < length; i++){
           list[i] = Integer.parseInt(br.readLine());
       }

       // 정렬 메소드
       Arrays.sort(list);

       // 출력
        for(int val : list){
           sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}