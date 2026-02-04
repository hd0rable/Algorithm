//https://www.acmicpc.net/problem/2805
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long start = 0;
        long end = arr[n-1];
        while(start < end){
            long mid = (start+end+1)/2;
            long len = 0;
            for(int i=0; i<n; i++){
                if(arr[i]>mid) len += (arr[i]-mid);
            }
            if(len >= m) start = mid;
            else end = mid -1;
        }
        System.out.println(start);
    }

}