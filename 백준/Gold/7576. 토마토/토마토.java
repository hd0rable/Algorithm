import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) queue.offer(new int[]{i, j}); //익은 토마토가 bfs 시작지점
                if(arr[i][j] == 0) dist[i][j] = -1;
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(dist[nx][ny] > -1) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }
}