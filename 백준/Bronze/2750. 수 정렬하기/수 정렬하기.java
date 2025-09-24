import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Scanner + 선택정렬
        Scanner sc = new Scanner(System.in);

       // 줄 수 입력
       int length = sc.nextInt();

        // 정수 해당 줄만큼 입력
       int [] list = new int [length];
       for (int i = 0; i < length; i++){
           list[i] = sc.nextInt();
       }

       // 기본 선택 정렬
       for (int i=0; i< length-1; i++){
           for (int j= i+1; j< length; j++ ){
               if(list[i]>list[j]){
                   int temp = list[i];
                   list[i] = list[j];
                   list[j] = temp;
               }
           }
       }
       // 출력
        for(int val : list){
            System.out.println(val);
        }
    }
}