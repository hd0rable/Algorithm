import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader + 선택정렬 + StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

       // 줄 수 입력
       int length = Integer.parseInt(br.readLine());

        // 정수 해당 줄만큼 입력
        int [] list = new int [length];
       for (int i = 0; i < length; i++){
           list[i] = Integer.parseInt(br.readLine());
       }

       // 기본 선택 정렬
       for (int i=0; i < length-1; i++){
           for (int j= i+1; j < length; j++ ){
               if(list[i]>list[j]){
                   int temp = list[i];
                   list[i] = list[j];
                   list[j] = temp;
               }
           }
       }

       // 출력
        for(int val : list){
           sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}