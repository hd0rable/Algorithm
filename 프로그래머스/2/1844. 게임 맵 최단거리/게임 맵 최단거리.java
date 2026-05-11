import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
int m = maps[0].length;
        int[] dx = new int[]{-1,1,0,0}; //상하좌우
        int[] dy = new int[]{0,0,-1,1};
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 진입점 큐추가, 방문처리
        queue.offer(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            int [] cur = queue.poll();
            int x = cur[0], y = cur[1];
            
            if(x == n-1 && y == m-1) break;
            
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny]!=0 || maps[nx][ny] == 0) continue;
                
                queue.offer(new int[]{nx,ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        
        //거리값이 갱신되지않음 -> 도달할수없음
        if(dist[n-1][m-1] == 0) return -1;
        else return dist[n-1][m-1];
    }
}