import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[7];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i= 0; i<7; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]%2 !=0) {
                sum += arr[i];
                if (min > arr[i])
                    min =arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        if (sum == 0) sb.append(-1);
        else sb.append(sum).append("\n").append(min).append("\n");
        System.out.println(sb);
    }
}