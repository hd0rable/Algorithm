import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur_x = Integer.parseInt(st.nextToken());
            int cur_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int move_x = Integer.parseInt(st.nextToken());
            int move_y = Integer.parseInt(st.nextToken());

            int[][] board = new int[l][l];
            int[] dx = {2,1,-1,-2,-2,-1,1,2};
            int[] dy = {1,2,2,1,-1,-2,-2,-1};
            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{cur_x,cur_y});
            board[cur_x][cur_y] = 1;

            while(!q.isEmpty()){
                int[] now = q.poll();
                if(now[0] == move_x && now[1] == move_y){
                    sb.append(board[move_x][move_y]-1).append('\n');
                    break;
                }
                for(int dir = 0; dir<8; dir++){
                    int nx = now[0] + dx[dir];
                    int ny = now[1] + dy[dir];
                    if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
                    if(board[nx][ny] > 0) continue;
                    board[nx][ny] = board[now[0]][now[1]] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        System.out.println(sb);
    }
}