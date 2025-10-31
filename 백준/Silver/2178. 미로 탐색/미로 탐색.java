import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dist = new int[n][m]; // 거리를 저장하는 배열
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        for (int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        dist[0][0] = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue; //범위벗어나면 건너뛰기
                if(dist[nx][ny] > 0 || arr[nx][ny]==0) continue; //이미 방문했으면,길이없으면 건너뛰기
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1; //거리 업데이트
                queue.offer(new int[]{nx,ny});
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}