//https://www.acmicpc.net/problem/2660
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxValue = 100;
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j) dist[i][j] = maxValue;
            }
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            if(m1 == -1 && m2 == -1) break;
            dist[m1][m2] = 1;
            dist[m2][m1] = 1;
        }

        for(int k=1; k<=n; k++)
            for(int i=1; i<=n; i++)
                for(int j=1; j<=n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int[] scores = new int[n + 1];
        int min = maxValue;

        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j) { //자기 자신 제외하고 가장 먼 거리 찾기
                    max = Math.max(max, dist[i][j]);
                }
            }
            scores[i] = max; //i번 사람 점수 확정
            min = Math.min(min, max); // 전체 최소 점수 갱신
        }

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == min) {
                candidates.add(i);
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(candidates.size()).append("\n");
        for (int c : candidates) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}