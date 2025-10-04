import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N>0){
            int n = N%10;
            if(arr[n]<count) //가지고 있는 세트에서 사용할수있는 숫자가 있다면 증가
                arr[n]++;
            else if(n==6 && arr[9]<count) //6일경우 9도 사용가능하므로 9가있다면 사용
                arr[9]++;
            else if(n==9 && arr[6]<count) //9일경우 6도 사용가능하므로 6이있다면 사용
                arr[6]++;
            else{
                count++; //사용할수 있는 숫자가없다면 세트 수 증가
                arr[n]++;
            }
            N=N/10;
        }
        System.out.println(count);
    }
}