import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] board = new int[m][n];
            Queue<int[]> q = new LinkedList<>();
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            int bug = 0;

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == 1){
                        q.offer(new int[]{i, j});
                        board[i][j] = 0; //방문처리
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur[0] + dx[dir];
                                int ny = cur[1] + dy[dir];
                                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                                if (board[nx][ny] == 0) continue;
                                q.offer(new int[]{nx,ny});
                                board[nx][ny] = 0;
                            }
                        }
                        bug++;
                    }
                }
            }
            sb.append(bug).append("\n");
        }
        System.out.println(sb);
    }
}