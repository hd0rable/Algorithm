//https://www.acmicpc.net/problem/2003
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int end = 0;
        int cnt = 0;
        for(int start=0; start<n; start++){
            while(end < n & sum < m){
                sum += a[end];
                end++;
            }
            if(sum == m) cnt++;
            sum -= a[start];
        }
        System.out.print(cnt);
    }

}