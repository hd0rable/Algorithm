//https://www.acmicpc.net/problem/10815
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0){
            int num = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(arr,num)>=0) sb.append(1).append(' ');
            else sb.append(0).append(' ');
        }

        System.out.println(sb);
    }

}