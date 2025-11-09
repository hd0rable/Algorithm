import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] board = new char[h][w];
            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> sg = new LinkedList<>();
            int[][] fire_dist = new int[h][w];
            int[][] sg_dist = new int[h][w];
            for(int i=0; i<h; i++){
                String line = br.readLine();
                for(int j=0; j<w; j++){
                    board[i][j] = line.charAt(j);
                    if(board[i][j] == '*'){
                        fire.offer(new int[]{i,j});
                        fire_dist[i][j] = 1;
                    }
                    if(board[i][j] == '@'){
                        sg.offer(new int[]{i,j});
                        sg_dist[i][j] = 1;
                    }
                }
            }

            while(!fire.isEmpty()){
                int[] cur = fire.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
                    if(board[nx][ny] == '#' || fire_dist[nx][ny] > 0) continue;
                    fire.offer(new int[]{nx,ny});
                    fire_dist[nx][ny] = fire_dist[cur[0]][cur[1]] + 1;
                }
            }

            boolean isSuccuss = false;
            while(!sg.isEmpty()){
                int[] cur = sg.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(nx<0 || nx>=h || ny<0 || ny>=w){
                       sb.append(sg_dist[cur[0]][cur[1]]).append('\n');
                       isSuccuss = true;
                       break;
                    }
                    if(board[nx][ny] == '#' || sg_dist[nx][ny] > 0) continue;
                    if(fire_dist[nx][ny] !=0 && sg_dist[cur[0]][cur[1]] + 1 >= fire_dist[nx][ny]) continue;
                    sg.offer(new int[]{nx,ny});
                    sg_dist[nx][ny] = sg_dist[cur[0]][cur[1]] + 1;
                }
                if(isSuccuss) break;
            }
            if(!isSuccuss) sb.append("IMPOSSIBLE").append('\n');
        }
        System.out.println(sb);
    }
}