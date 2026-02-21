import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        String[] arr = new String[n+1];
        for(int i=1; i<=n; i++){
            String input = br.readLine();
            map.put(input,i);
            arr[i] = input;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String input = br.readLine();
            if(input.charAt(0) >='1' && input.charAt(0) <='9')
                sb.append(arr[Integer.parseInt(input)]);
            else
                sb.append(map.get(input));
            sb.append('\n');
        }

        System.out.print(sb);
    }

}