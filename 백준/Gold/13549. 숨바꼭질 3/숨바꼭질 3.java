import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist,-1);

        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(n);
        dist[n] = 0;

        while(dist[k]==-1){
            int cur = dq.poll();
            for(int nx : new int[]{2*cur,cur-1,cur+1}){
                if(nx<0 || nx > 100000) continue;
                if(dist[nx] != -1) continue;
                if(nx == 2*cur){
                    dist[nx] = dist[cur];
                    dq.addFirst(nx);
                }
                else {
                    dist[nx] = dist[cur] + 1;
                    dq.addLast(nx);
                }
            }
        }
        System.out.println(dist[k]);
    }
}