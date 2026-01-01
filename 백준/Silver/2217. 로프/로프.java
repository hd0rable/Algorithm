import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); //오름차순 정렬

        int ans = 0;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans,arr[n-i]*i);
        }
        System.out.println(ans);
    }
}