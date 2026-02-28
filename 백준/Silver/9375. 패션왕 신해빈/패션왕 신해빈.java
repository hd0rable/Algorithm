import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(br.readLine());

       StringBuilder sb = new StringBuilder();
       while(t-->0){
           HashMap<String,Integer> map = new HashMap<>();
           int n = Integer.parseInt(br.readLine());

           while(n-->0) {
               StringTokenizer st = new StringTokenizer(br.readLine());
               st.nextToken();
               String category = st.nextToken();

               map.put(category, map.getOrDefault(category,0)+1);
           }

           int result = 1;
           for(int count: map.values()){
               result *= (count + 1);
           }
           sb.append(result-1).append('\n');
       }
       System.out.println(sb);
    }
}