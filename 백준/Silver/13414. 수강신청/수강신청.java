import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(int i=1; i<=l; i++){
            String input = br.readLine();
            if(map.containsKey(input))
                map.remove(input);
            map.put(input,i);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String key : map.keySet()) {
            if (cnt == k) break;

            sb.append(key).append('\n');
            cnt++;
        }

        System.out.print(sb);
    }

}