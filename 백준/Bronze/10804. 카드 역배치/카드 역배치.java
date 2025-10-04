import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int i=0 ; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=a-1,k=b-1; j<b && k>=a && j<k; j++,k--){
                // j가 k보다 작을때까지만 j가 k보다 커진경우는이미 바뀐 후
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<20; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}