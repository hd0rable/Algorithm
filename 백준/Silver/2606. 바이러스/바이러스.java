import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<>();
        boolean[] isVisited = new boolean[n+1];
        int v1,v2;
        StringTokenizer st;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }

        int cnt = -1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        isVisited[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for(int next : list[cur]){
                if(isVisited[next]) continue;
                q.offer(next);
                isVisited[next] = true;
            }
        }
        System.out.print(cnt);
    }

}
