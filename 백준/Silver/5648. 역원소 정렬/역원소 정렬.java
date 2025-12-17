import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n 입력받는 첫째줄 입력 처리
        int n = Integer.parseInt(st.nextToken());
        arr = new long[n];
        while(st.hasMoreTokens()){
            arr[index++] = Long.parseLong(st.nextToken());
            reverse(index-1);
        }

        while(index < n){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[index++] = Long.parseLong(st.nextToken());
                reverse(index-1);
            }
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(arr[i]).append('\n');
        System.out.println(sb);
    }

    static void reverse(int index){
        long num = arr[index];
        long result = 0;
        while(num!=0){
            long a = num % 10;
            result = result*10 + a;
            num/=10;
        }
        arr[index] = result;
    }

}