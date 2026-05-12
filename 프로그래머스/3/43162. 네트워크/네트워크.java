import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!isVisited[i]) {
                cnt++;
                queue.offer(i);
                isVisited[i] = true;
            }
        
            while(!queue.isEmpty()){
                int nx = queue.poll();
                
                for(int j=0; j<n; j++){
                    if(computers[nx][j] == 0 || nx==j) continue;
                    if(isVisited[j]) continue;
                    queue.offer(j);
                    isVisited[j] = true;
                }
            }
        }
        return cnt;
    }
}