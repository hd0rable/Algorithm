import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        String N = br.readLine();
        for(int i=0; i<N.length(); i++){
            arr[N.charAt(i)-'0']++;
        }
        arr[6] = (arr[6] + arr[9] + 1)/2; //9->6
        arr[9] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<10; i++){
            max = Math.max(max,arr[i]);
        }
        System.out.println(max);
    }
}