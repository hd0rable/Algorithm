import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        int left = 0;
        int right = n-1;
        int ansL = 0;
        int ansR = 0;
        long min = Long.MAX_VALUE;
        while(left < right){
            long sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                ansL = left;
                ansR = right;
            }

            if(sum > 0) right--;
            else if(sum < 0) left++;
            else break;
        }

        System.out.print(arr[ansL]);
        System.out.print(' ');
        System.out.print(arr[ansR]);
    }
}