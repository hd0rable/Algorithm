//https://www.acmicpc.net/problem/1822
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        long[] a = new long[nA];
        long[] b = new long[nB];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nA; i++)
            a[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nB; i++)
            b[i] = Long.parseLong(st.nextToken());


        Arrays.sort(b);
        int cnt = nA;
        for(int i=0; i<nA; i++){
            int num = Arrays.binarySearch(b,a[i]);
            if(num>=0){
                cnt--;
                a[i] = -1;
            }
        }

        Arrays.sort(a);

        sb.append(cnt).append('\n');
        for(int i=0; i<nA; i++) {
            if(a[i] == -1) continue;
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);
    }

}