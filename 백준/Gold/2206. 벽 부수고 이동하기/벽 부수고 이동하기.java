import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        int[][][] dist = new int[n][m][2];
        q.offer(new int[]{0,0,0});
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1]; int broken = cur[2];

            if(x == n-1 && y == m-1){
                System.out.println(dist[x][y][broken]);
                return;
            }

            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || nx>=n || ny<0 || ny>=m) continue;
                if(board[nx][ny] == 0 && dist[nx][ny][broken] == 0){
                    dist[nx][ny][broken] = dist[x][y][broken] + 1;
                    q.offer(new int[]{nx,ny,broken});
                }
                else if(board[nx][ny] == 1 && broken == 0 &&dist[nx][ny][1] == 0){ //벽이면서 부시지않은 상태면서 부순 벽을 방문하지않았다면
                    dist[nx][ny][1] = dist[x][y][broken] + 1;
                    q.offer(new int[]{nx,ny,1});
                }
            }
        }
        System.out.println(-1);
    }
}