import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] isUsed;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2]; //[n][0]내구도, [n][1] 무게
        isUsed = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        func(0,0);
        System.out.println(max);
    }

    static void func(int cur, int cnt){
        if(cur == n){
            max = Math.max(max,cnt);
            return;
        }

        // 계란을 깰수 없음
        // 선택한 계란이 깨져있거나 다른 모든계란이 깨져있거나
        if(arr[cur][0] <=0 || cnt == n-1){
            func(cur+1,cnt);
            return;
        }
        //계란 깨기
        for (int i = 0; i < n; i++) {
            if (i == cur)  continue; //자기자신을 선택한 경우 제외
            if (arr[i][0] <= 0) continue; //고른개란이 깨졌다면 제외
            arr[cur][0] -= arr[i][1];
            arr[i][0] -= arr[cur][1];
            if (arr[cur][0] <= 0) cnt++;
            if (arr[i][0] <= 0) cnt++;

            func(cur + 1, cnt);

            if (arr[cur][0] <= 0) cnt--;
            if (arr[i][0] <= 0) cnt--;
            arr[cur][0] += arr[i][1];
            arr[i][0] += arr[cur][1];
        }
    }

}