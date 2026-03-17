import java.io.*;
import java.util.*;
public class Main {
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        isVisited = new boolean[n+1];
        int v1,v2;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        //번호가 작은 것 부터 방문하기 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(v);
        isVisited = new boolean[n+1];
        sb.append('\n');
        bfs();

        System.out.print(sb);
    }

    static void dfs(int cur){
        isVisited[cur] = true;
        sb.append(cur).append(' ');
        for(int next : list[cur]){
            if(isVisited[next]) continue;
            dfs(next);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        isVisited[v] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(' ');
            for(int next : list[cur]){
                if(isVisited[next]) continue;
                q.offer(next);
                isVisited[next] = true;
            }
        }
    }
}
