import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> map = new HashMap<>();
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken()); //사이트, 비밀번호
        }
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            String key = br.readLine();
            sb.append(map.get(key)).append('\n');
        }

        System.out.print(sb);
    }


}