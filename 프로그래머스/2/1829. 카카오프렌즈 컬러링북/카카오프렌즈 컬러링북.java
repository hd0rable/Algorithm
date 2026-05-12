import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] dx = new int[]{-1,1,0,0}; //상하좌우
        int[] dy = new int[]{0,0,-1,1};
        Queue<int[]> queue = new ArrayDeque<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(picture[i][j]!=0){
                    queue.offer(new int[]{i,j,picture[i][j]});
                    numberOfArea++;
                    
                    int SizeOfOneArea = 0;
                    while(!queue.isEmpty()){
                        SizeOfOneArea++;
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1], color = cur[2];
                        
                        for(int d=0; d<4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            
                            if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                            if(picture[nx][ny] != color) continue;
                            
                            queue.offer(new int[]{nx,ny,color});
                            picture[nx][ny] = 0;  
                        }
                    }
                    maxSizeOfOneArea = Math.max(SizeOfOneArea-1,maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}