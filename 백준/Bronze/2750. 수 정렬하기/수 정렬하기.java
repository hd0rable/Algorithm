import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

       // 줄 수 입력
       int length = sc.nextInt();
        // 정수 해당 줄만큼 입력
       int [] list = new int [length];
       for (int i = 0; i < length; i++){
           list[i] = sc.nextInt();
       }
       for (int i=0; i< length-1; i++){
           for (int j= i+1; j< length; j++ ){
               if(list[i]>list[j]){
                   int temp = list[i];
                   list[i] = list[j];
                   list[j] = temp;
               }
           }
       }
       for (int i = 0; i < length; i++){
           System.out.println(list[i]);
       }
    }
}