import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        Queue<int[]> q1 = new LinkedList<>(); //불
        Queue<int[]> q2 = new LinkedList<>(); //지훈이
        int[][] dist1 = new int[r][c]; //불이 퍼지는 거리
        int[][] dist2 = new int[r][c]; //지훈이가 지나가는 거리
        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++){
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'F'){
                    q1.offer(new int[]{i,j});
                    dist1[i][j] = 1;
                }
                if(board[i][j] == 'J'){
                    q2.offer(new int[]{i,j});
                    dist2[i][j] = 1;
                }
            }
        }

        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        //불이 퍼지는 거리 bfs로 계산
        while(!q1.isEmpty()){
            int[] cur = q1.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                if(board[nx][ny] == '#' || dist1[nx][ny] > 0) continue; //벽이거나 이미 방문한경우
                dist1[nx][ny] = dist1[cur[0]][cur[1]] + 1;
                q1.offer(new int[]{nx,ny});
            }
        }

        //지훈이의 탈출 경로 bfs로 계산
        while(!q2.isEmpty()){
            int[] cur = q2.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx<0 || nx>=r || ny<0 || ny>=c){ //범위를 벗어났다는 것은 탈출했다는 의미
                    System.out.println(dist2[cur[0]][cur[1]]);
                    return;
                }
                if(board[nx][ny] == '#' || dist2[nx][ny] > 0) continue; //벽이거나 이미 방문한경우
                if(dist1[nx][ny]!=0 && dist1[nx][ny] <= dist2[cur[0]][cur[1]] + 1) continue; //이미 불이 퍼진 경우
                dist2[nx][ny] = dist2[cur[0]][cur[1]] + 1;
                q2.offer(new int[]{nx,ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}