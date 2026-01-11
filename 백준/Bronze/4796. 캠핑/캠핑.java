import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while(true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l==0 && p==0 && v ==0) break;
            sb.append("Case ").append(++cnt)
                    .append(": ").append(v/p*l + Math.min(v%p,l)).append('\n');
        }
        System.out.println(sb);
    }
}