import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        Queue<Node> q = new LinkedList<>();
        int[] dx = {1,0,-1,0,0,0};
        int[] dy = {0,1,0,-1,0,0};
        int[] dz = {0,0,0,0,1,-1};

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) q.offer(new Node(i,j,k));
                    if(arr[i][j][k] == 0) dist[i][j][k] = -1;

                }
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int dir = 0; dir < 6; dir++){
                int nz = cur.z + dz[dir];
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m || nz<0 || nz>=h) continue;
                if(dist[nz][nx][ny] > -1) continue;
                q.offer(new Node(nz,nx,ny));
                dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
            }
        }

        int ans = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(dist[i][j][k]==-1) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans,dist[i][j][k]);
                }
            }
        }
        System.out.println(ans);

    }

    public static class Node{
        int z;
        int x;
        int y;
        public Node(int z,int x,int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}