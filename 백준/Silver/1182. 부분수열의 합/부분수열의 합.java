import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        func(0,0);
        if(s == 0) cnt--;
        System.out.println(cnt);
    }

    static void func(int cur, int sum){
        if(cur == n) {
            if (sum == s) cnt++;
            return;
        }
        func(cur+1, sum); //안더하고
        func(cur+1, sum + arr[cur]); //더하기
    }


}