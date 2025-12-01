import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] arr;
    static int[] n_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        n_arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            n_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n_arr);
        func(0,0);
        System.out.println(sb);
    }

    static void func(int k, int arr_num){
        if(k == m){
            for(int i=0; i<m; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=0; i<n; i++){
            if(arr_num <= n_arr[i]) {
                arr[k] = n_arr[i];
                func(k + 1, arr[k]);
            }
        }

    }
}