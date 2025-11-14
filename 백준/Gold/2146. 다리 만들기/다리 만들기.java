import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandId = 1;
        Queue<int[]> q1 = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        // 같은섬 라벨링 bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1 || arr[i][j] == 0) continue;
                q1.offer(new int[]{i, j}); // 각 배열의 값을 섬 id로 라벨링
                visited[i][j] = 1;
                while (!q1.isEmpty()) {
                    int[] cur = q1.poll();
                    int x = cur[0], y = cur[1];
                    arr[x][y] = islandId; //땅의 값을 섬id로 라벨링
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n)  continue; //범위벗어나는 값
                        if (visited[nx][ny] == 1 || arr[nx][ny] == 0)  continue; //이미 방문한 땅이거나 바다면
                        q1.offer(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
                islandId++;
            }
        }

        // 모든 땅에대해 최단거리 bfs
        int[][] dist = new int[n][n];
        Queue<int[]> q2 = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    q2.offer(new int[]{i, j});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            int x = cur[0], y = cur[1];
            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue; //범위벗어나는 값
                if(arr[nx][ny] == arr[x][y])  continue; //같은 섬일경우
                if(arr[nx][ny] != 0) // 다른 섬일경우
                    min = Math.min(min,dist[nx][ny]+dist[x][y]);
                else{ //바다일경우 거리증가
                    arr[nx][ny] = arr[x][y];
                    dist[nx][ny] = dist[x][y] + 1;
                    q2.offer(new int[]{nx,ny});
                }
            }
        }
        System.out.println(min);
    }

}