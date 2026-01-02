import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            list.add(new int[]{sm*100 +sd,em*100 + ed});
        }

        int t = 301; //현재 시간
        int ans = 0;
        while(t < 1201){
            int nxt_t = t; //이번에 추가할 꽃으로 인해 변경된 시간
            for(int i=0; i<n; i++){
                // 현재 시점에서 피어있는 꽃들중에서 가장 마지막에 지는 꽃 선택
                if(list.get(i)[0] <= t && list.get(i)[1] > nxt_t)
                    nxt_t = list.get(i)[1];
            }
            if(nxt_t == t){
                ans = 0;
                break;
            }
            ans++;
            t = nxt_t;
        }
        System.out.println(ans);
    }
}