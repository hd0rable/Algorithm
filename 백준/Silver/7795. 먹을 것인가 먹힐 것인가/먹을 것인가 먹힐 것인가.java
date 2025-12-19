import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t--> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arrA = new int[n];
            int[] arrB = new int[m];

            for (int i = 0; i < n; i++)
                arrA[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                arrB[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arrB);

            int cnt = 0;
            for(int i=0; i<n; i++) {
                int low = 0;
                int high = m-1;
                int index = 0;
                while(low <= high){
                    int mid = (low + high) /2 ;
                    if(arrB[mid] < arrA[i]){
                        low = mid + 1;
                        index = mid + 1;
                    }
                    else high = mid - 1;
                }
                cnt += index;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}