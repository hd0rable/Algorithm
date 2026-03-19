import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] dist = new int[n + 1]; // 상근이로부터 거리
        Arrays.fill(dist, -1);
        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<>();

        StringTokenizer st;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }


        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        int ans = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if (dist[cur] >= 2) continue;

            for(int next : list[cur]){
                if(dist[next] !=-1) continue;
                dist[next] = dist[cur] + 1;
                q.offer(next);
                ans++;
            }
        }
        System.out.print(ans);
    }
}
