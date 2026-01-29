//https://www.acmicpc.net/problem/1654
import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for(int i=0; i<k; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long start = 1;
        long end = Integer.MAX_VALUE; //0x7fffffff
        while(start < end){
            long mid = (start+end+1)/2;
            if(solve(mid)) start = mid;
            else end = mid-1;
        }
        System.out.println(start);
    }

    static boolean solve(long x){
        long cur = 0;
        for(int i=0; i<k; i++)
            cur += arr[i] / x;
        return cur >= n;
    }

}