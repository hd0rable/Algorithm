//https://www.acmicpc.net/problem/4803
import java.io.*;
import java.util.*;
public class Main {
    static boolean[] vis;
    static ArrayList<Integer>[] list;
    static int isTree;
    static int tc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            vis = new boolean[n+1];
            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++)
                list[i] = new ArrayList<>();
            int treeCount = 0;
            while(m-->0){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }
            for(int i=1; i<=n; i++){
                if(vis[i]) continue;
                vis[i] = true;
                isTree = 1;
                dfs(i,-1);
                treeCount += isTree;
            }
            sb.append("Case ").append(++tc).append(": ");
            if(treeCount == 0)
                sb.append("No trees.\n");
            else if(treeCount == 1)
                sb.append("There is one tree.\n");
            else
                sb.append("A forest of ").append(treeCount).append(" trees.\n");
        }
        System.out.print(sb);
    }

    static void dfs(int cur,int prev){
        for(int nxt : list[cur]){
            if(nxt == prev) continue;//next가 부모일 경우 건너뛰기
            if(vis[nxt]){ //트리일 경우 자식은 이전에 방문한적이 없어야함
                isTree = 0;
                continue;
            }
            vis[nxt] = true;
            dfs(nxt,cur);
        }

    }

}
