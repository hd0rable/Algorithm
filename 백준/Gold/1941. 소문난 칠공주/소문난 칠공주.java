import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr = new char[5][5];
    static int[][] selected = new int[7][2];
    static int result = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++)
                arr[i][j] = line.charAt(j);
        }
        combinationDFS(0,0,0);
        System.out.println(result);
    }

    static void combinationDFS(int index, int totalCount, int sCount) {
        if (totalCount + (25 - index) < 7) return; //가지치기
        if (totalCount == 7) {
            if (sCount >= 4 && checkConnectivity())
                result++;
            return;
        }

        if(index < 25) {
            int x = index / 5;
            int y = index % 5;

            selected[totalCount][0] = x;
            selected[totalCount][1] = y;

            int newSCount = arr[x][y] == 'S' ? sCount + 1 : sCount;
            combinationDFS(index + 1, totalCount + 1, newSCount); //현재학생을 선택하는 경우
            combinationDFS(index + 1, totalCount, sCount); //현재학생을 선택하지 않는 경우
        }
    }

    static boolean checkConnectivity(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[5][5];
        boolean[][] isPrincess = new boolean[5][5];
        for (int i = 0; i < 7; i++) {
            isPrincess[selected[i][0]][selected[i][1]] = true;
        }

        // 선택된 학생들이 연결되어있는지 bfs로 확인
        q.offer(new int[]{selected[0][0], selected[0][1]});
        isVisited[selected[0][0]][selected[0][1]] = true;
        int connectedCnt = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 5 || nx < 0 || ny >= 5 || ny < 0) continue; //범위를 벗어나면
                if(!isPrincess[nx][ny]) continue; //칠공주가 아니라면
                if(isVisited[nx][ny]) continue; //이미 선택된 학생이라면
                q.offer(new int[]{nx,ny});
                isVisited[nx][ny] = true;
                connectedCnt++;
            }
        }
        return connectedCnt == 7;
    }

}