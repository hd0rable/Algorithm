import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] number = new int[10];
        int result =1;
        for(int i= 0; i<3; i++)
            result *= Integer.parseInt(br.readLine());
        while(result>0){
            number[result%10]++;
            result/=10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(number[i]).append("\n");
        }
        System.out.println(sb);
    }
}