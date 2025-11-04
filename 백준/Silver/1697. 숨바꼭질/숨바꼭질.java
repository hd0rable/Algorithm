import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        dist[n] = 1;
        q.offer(n);

        while(dist[k] == 0){ //종료조건 dist[k] != 0 동생을 찾을때까지
            int cur = q.poll();
            for(int next : new int[]{cur-1,cur+1,2*cur}) {
                if(next > 100000 || next<0) continue; //범위초과
                if (dist[next] > 0) //이미 최단경로로 방문했을경우
                    continue;
                dist[next] = dist[cur] + 1; //거리 업데이트
                q.offer(next);
            }
        }

        System.out.println(dist[k]-1);

    }
}