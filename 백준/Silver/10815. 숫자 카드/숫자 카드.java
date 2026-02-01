import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[Integer.parseInt(st.nextToken())+10000000] = true;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0){
            int num = Integer.parseInt(st.nextToken());
            if(arr[num+10000000]) sb.append(1).append(' ');
            else sb.append(0).append(' ');
        }

        System.out.println(sb);
    }

}