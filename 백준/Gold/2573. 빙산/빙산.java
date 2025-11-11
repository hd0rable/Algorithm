import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            year++;
            melting(); //얼음 녹이기
            initVisited(); //방문 배열 초기화
            int status = status();
            if(status == 0){
                System.out.println(0);
                return;
            }
            else if(status == 1) continue;
            else break;
        }
        System.out.println(year);

    }

    public static void melting(){
        int[][] zero = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0) continue;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (check(nx,ny) && arr[nx][ny] == 0) zero[i][j]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = Math.max(0,arr[i][j]-zero[i][j]);
            }
        }
    }

    public static boolean check(int i, int j){
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public static void initVisited(){
        for(int i=0; i<n; i++){
            Arrays.fill(visited[i],0);
        }
    }

    // 0 : 빙산이 다 녹음, 1 : 아직 한 덩이, 2 : 분리됨
    public static int status(){
        int x = -1, y = -1;
        int cnt1 = 0; // 빙산의 개수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]!=0){
                    x = i;
                    y = j;
                    cnt1++;
                }
            }
        }
        if(cnt1 == 0) return 0; // 빙산이 남아있는 칸이 없음

        int cnt2 = 0; // (x, y)와 붙어있는 빙산의 수
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = 1;
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt2++;
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(!check(nx, ny) || visited[nx][ny] == 1 || arr[nx][ny] <= 0) continue;
                visited[nx][ny] = 1;
                q.offer(new int[]{nx,ny});
            }
        }
        if(cnt1 == cnt2) return 1; // 전체 빙산의 수와 (x, y)와 붙어있는 빙산의 수가 일치하므로 아직 한 덩이
        return 2;
    }

}