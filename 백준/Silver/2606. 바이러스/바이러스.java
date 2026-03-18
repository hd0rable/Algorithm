import java.io.*;
import java.util.*;
public class Main {
    static boolean[] isVisited;
    static ArrayList<Integer>[] list;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<>();
        isVisited = new boolean[n+1];
        int v1,v2;
        StringTokenizer st;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        dfs(1);
        System.out.print(cnt);
    }

    static void dfs(int cur){
        isVisited[cur] = true;
        for(int next : list[cur]){
            if(isVisited[next]) continue;
            cnt++;
            dfs(next);
        }
    }
}
