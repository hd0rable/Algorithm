import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        boolean[] isVisited = new boolean[n+1];
        int u,v;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        //bfs
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(isVisited[i]) continue;
            cnt++;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            isVisited[i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : list[cur]){
                    if(isVisited[next]) continue;
                    q.offer(next);
                    isVisited[next] = true;
                }
            }
        }
        System.out.print(cnt);
    }
}
