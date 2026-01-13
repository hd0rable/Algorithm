//https://www.acmicpc.net/problem/2960
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int cnt = 0;
        for(int i=2; i<=n; i++){
            if(arr[i] == 1) continue;
            for(int j=i; j<=n; j+=i){
                if(arr[j] == 1) continue;
                arr[j] = 1;
                cnt++;
                if(cnt == k){
                    System.out.println(j);
                    return;
                }
            }
        }

    }
}