import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int len = Integer.MAX_VALUE;
        int sum = arr[0];
        int end = 0;
        for(int start=0; start<n; start++){
            while(end < n && sum < s){
                end++;
                if(end != n) sum += arr[end];
            }
            if(end == n) break;
            len = Math.min(len,end - start + 1);
            sum -= arr[start];
        }
        if(len == Integer.MAX_VALUE) len = 0;
        System.out.print(len);
    }
}