import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int en = 0;
        int min = Integer.MAX_VALUE;
        for(int start = 0; start <n; start++){
            while(en < n && arr[en] - arr[start] < m) en++;
            if(en == n) break;
            min = Math.min(min, arr[en] - arr[start]);
        }

        System.out.print(min);
    }
}