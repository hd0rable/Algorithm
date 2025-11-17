import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                board[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        int[][][] cnt = new int[h][w][k+1]; //3차원은 말처럼 움직인 횟수 저장
        Queue<int[]> q = new LinkedList<>();
        int[] mdx = {1,0,-1,0}; //원숭이로 움직일수있는 좌표
        int[] mdy = {0,1,0,-1};
        int[] hdx = {2,1,-1,-2,-2,-1,1,2}; //말로 움직일수있는 좌표
        int[] hdy = {1,2,2,1,-1,-2,-2,-1};


        cnt[0][0][0] = 1;
        q.offer(new int[]{0,0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], hcnt = cur[2];
            if(x == h-1 && y== w-1) {
                System.out.println(cnt[x][y][hcnt]-1);
                return;
            }
            if(hcnt < k) { //말로 움직일수있는 횟수가 아직 남은경우
                for(int dir=0; dir<8; dir++){
                    int nx = x + hdx[dir];
                    int ny = y + hdy[dir];
                    if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
                    if(cnt[nx][ny][hcnt+1] > 0 || board[nx][ny] == 1) continue;
                    cnt[nx][ny][hcnt+1] = cnt[x][y][hcnt] + 1;
                    q.offer(new int[]{nx,ny,hcnt+1});
                }
            }
            for(int dir=0; dir<4; dir++){
                int nx = x + mdx[dir];
                int ny = y + mdy[dir];
                if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
                if(cnt[nx][ny][hcnt] > 0 || board[nx][ny] == 1) continue;
                cnt[nx][ny][hcnt] = cnt[x][y][hcnt] + 1;
                q.offer(new int[]{nx,ny,hcnt});
            }
        }
        System.out.println(-1);
    }
}