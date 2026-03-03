import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(br.readLine());

       StringBuilder sb = new StringBuilder();
       while(t-->0){
           int k = Integer.parseInt(br.readLine());
           TreeMap<Integer,Integer> map = new TreeMap<>();
           while(k-->0){
               StringTokenizer st = new StringTokenizer(br.readLine());
               char op = st.nextToken().charAt(0);
               int n = Integer.parseInt(st.nextToken());
               if(op == 'I'){
                   map.put(n,map.getOrDefault(n,0)+1);
               }
               else{
                   if (map.isEmpty()) continue;

                   int target = (n==1) ? map.lastKey() : map.firstKey();

                   if(map.get(target) ==1)
                       map.remove(target);
                   else map.put(target,map.get(target)-1);
               }
           }
           if(map.isEmpty()) sb.append("EMPTY");
           else sb.append(map.lastKey()).append(' ').append(map.firstKey());
           sb.append('\n');
       }
       System.out.println(sb);

    }


}