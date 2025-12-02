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
        func(0);
        System.out.println(sb);
    }

    static void func(int k){
        if(k == m){
            for(int i=0; i<m; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        int before = 0;
        for(int i=0; i<n; i++){
            if(before !=n_arr[i]) { // 이전 수열의 마지막 항과 새로운 수열의 마지막 항이 같으면 중복 수열
                arr[k] = n_arr[i];
                before = arr[k];
                func(k + 1);
            }
        }
    }
}