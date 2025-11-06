import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = st.charAt(j);
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>(); // 일반인
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) { //같은글자 bfs 시작
                        int[] cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;
                            if (visited[nx][ny] || board[nx][ny] != board[cur[0]][cur[1]])
                                continue;
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    cnt1++;
                }
            }
        }
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) { //적록색맹 bfs 시작
                        int[] cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;
                            boolean sameColor = (board[nx][ny] == board[cur[0]][cur[1]]) ||
                                    ((board[nx][ny] == 'R' || board[nx][ny] == 'G') && (board[cur[0]][cur[1]] == 'R'
                                            || board[cur[0]][cur[1]] == 'G'));
                            if (visited[nx][ny] || !sameColor)
                                continue;
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }
}