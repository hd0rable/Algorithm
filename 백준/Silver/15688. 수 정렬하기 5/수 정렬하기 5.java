import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num+1000000]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=2000000; i++){
            while(arr[i]-- > 0) {
                sb.append(i-1000000).append('\n');
            }
        }
        System.out.println(sb);
    }

}