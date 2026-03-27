import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<int[]>[] adj;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,d});
            adj[v].add(new int[]{u,d});
        }

        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            vis = new boolean[n+1];
            sb.append(dfs(u,v,0)).append('\n');
        }
        System.out.print(sb);
    }

    static int dfs(int u, int v, int dis){
        if(u==v) return dis;

        vis[u] = true;
        for(int[] nxt: adj[u]){
            if(vis[nxt[0]]) continue;
            int result = dfs(nxt[0],v,dis+nxt[1]);
            if(result != -1) return result;
        }
        return -1;
    }

}