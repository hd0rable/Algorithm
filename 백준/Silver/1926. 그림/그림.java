import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0; //그림의 최댓값
        int num = 0; //그램 갯수

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] || arr[i][j] == 0) continue;
                num++;
                queue.offer(new Pair(i,j));
                visited[i][j] = true;
                int area = 0;
                while(!queue.isEmpty()){
                    area++;
                    Pair cur = queue.poll();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if(nx<0 || nx>=n || ny <0 || ny>=m) continue;
                        if(visited[nx][ny] || arr[nx][ny] !=1) continue;
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }
                }
                max = Math.max(area, max);
            }
        }
        System.out.println(num);
        System.out.println(max);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}