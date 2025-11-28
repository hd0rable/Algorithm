import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n,m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

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
        // 현재 k개까지 수를 택함
        // at 현재위치 (어디서부터 시작하는지)
        if(k==m){
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<=n; i++){
            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                func(i+1,k+1);
                isUsed[i] = false;
            }
        }
    }

}