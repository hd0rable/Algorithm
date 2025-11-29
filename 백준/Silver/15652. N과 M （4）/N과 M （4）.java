import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n,m;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        func(1,0);
        System.out.println(sb);
    }

    static void func(int at, int k){
        if(k==m){
            for(int i=0; i<m; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=at; i<=n; i++){
            arr[k] = i;
            func(i,k+1);
        }
    }

}