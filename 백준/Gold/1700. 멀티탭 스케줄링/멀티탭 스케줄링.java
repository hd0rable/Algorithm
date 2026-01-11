//https://www.acmicpc.net/problem/1700
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[k];
        for(int i=0; i<k; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Set<Integer> multitap = new HashSet<>(); // 현재 꽂힌 물건들
        int ans = 0;

        for (int i = 0; i < k; i++) {
            int now = arr[i];

            // 1. 이미 꽂혀 있으면 패스
            if (multitap.contains(now)) continue;

            // 2. 빈 자리가 있으면 꽂기
            if (multitap.size() < n) {
                multitap.add(now);
                continue;
            }

            // 3. 자리가 없으면 하나 뽑기
            int targetToDelete = -1;
            int lastUsage = -1;

            for (int plugged : multitap) {
                // 앞으로 언제 쓰이는지 찾기
                int nextUsage = Integer.MAX_VALUE;
                for (int j = i + 1; j < k; j++) {
                    if (arr[j] == plugged) {
                        nextUsage = j;
                        break;
                    }
                }
                
                if (nextUsage > lastUsage) {
                    lastUsage = nextUsage;
                    targetToDelete = plugged;
                }
            }

            multitap.remove(targetToDelete);
            multitap.add(now);
            ans++;
        }

        System.out.println(ans);
    }

}