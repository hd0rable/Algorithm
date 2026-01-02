import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] flowers = new int[n][2];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i][0] = sm * 100 + sd;
            flowers[i][1] = em * 100 + ed;
        }

        //시작일 빠른순, 종료일 높은 순
        Arrays.sort(flowers,(d1,d2)->{
            if(d1[0] == d2[0])
                return d2[1] - d1[1];
            return d1[0] - d2[0];
        });

        int t = 301;    // 현재 커버해야 하는 시점
        int ans = 0;
        int idx = 0;    // 탐색 중인 꽃의 인덱스
        int max_end = 0; // 현재 시점 이전에 피는 꽃들 중 가장 늦게 지는 날짜

        while(t < 1201){
            boolean found = false; //새 꽃을 찾았는지 여부

            // 2. 현재 시점(t) 이전에 피는 꽃들을 모두 검사하며 가장 늦게 지는 날짜 찾기
            while (idx < n && flowers[idx][0] <= t) {
                if (flowers[idx][1] > max_end) {
                    max_end = flowers[idx][1];
                    found = true;
                }
                idx++;
            }

            if (found) {
                ans++;
                t = max_end; // 시간을 가장 늦게 지는 날짜로 점프
            } else {
                // 더 이상 연결할 수 있는 꽃이 없는 경우
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}