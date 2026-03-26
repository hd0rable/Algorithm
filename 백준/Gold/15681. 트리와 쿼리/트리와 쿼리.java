//https://www.acmicpc.net/problem/15681
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int[] subCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        subCount = new int[n+1];
        vis = new boolean[n+1];

        countSubTree(r);

        StringBuilder sb = new StringBuilder();
        while(q-->0){
            int u = Integer.parseInt(br.readLine());
            sb.append(subCount[u]).append('\n');
        }
        System.out.print(sb);
    }

    static int countSubTree(int cur){
        vis[cur] = true;
        for(int nxt: adj[cur]){
            if(vis[nxt]) continue;
            subCount[cur] += countSubTree(nxt);
        }
        subCount[cur]++;
        return subCount[cur];
    }

}
