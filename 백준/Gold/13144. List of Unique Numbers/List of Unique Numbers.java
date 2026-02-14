import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[n+1];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        long ans = 0;
        for(int end = 0; end <n; end++){
            count[arr[end]]++;

            while(count[arr[end]] > 1){
                count[arr[start]]--;
                start++;
            }

            ans +=(end - start +1);
        }
        System.out.print(ans);
    }

}