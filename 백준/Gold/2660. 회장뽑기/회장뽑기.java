import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            if(m1 == -1 && m2 == -1) break;
            list[m1].add(m2);
            list[m2].add(m1);
        }

        int[] scores = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            scores[i] = bfs(i);
            min = Math.min(min,scores[i]);
        }

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == min) {
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(candidates.size()).append("\n");
        for (int c : candidates) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }

    static int bfs(int st){
       Queue<Integer> q = new LinkedList<>();
       int[] dist = new int[n+1];
       Arrays.fill(dist,-1);

       q.offer(st);
       dist[st]=0;
       int max = 0;

       while(!q.isEmpty()){
           int cur = q.poll();

           for(int next : list[cur]){
               if(dist[next] == -1){
                   dist[next] = dist[cur]+1;
                   max = Math.max(max,dist[next]);
                   q.offer(next);
               }
           }
       }
       return max;
    }
}