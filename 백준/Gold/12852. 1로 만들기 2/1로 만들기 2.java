import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n+1];
        int[] pre = new int[n+1];
        d[1] = 0;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1] + 1;
            pre[i] = i-1; //경로 추적
            if(i%2==0 && d[i] > d[i/2]+1) {
                d[i] = d[i/2]+1;
                pre[i] = i/2;
            }
            if(i%3==0 && d[i] > d[i/3]+1 ) {
                d[i] = d[i/3]+1;
                pre[i] = i/3;
            }
        }
        System.out.println(d[n]);
        int cur = n;
        while(true){
            sb.append(cur).append(' ');
            if(cur == 1) break;
            cur = pre[cur];
        }
        System.out.println(sb);
    }
}