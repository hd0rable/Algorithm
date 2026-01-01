import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        //끝나는 시간이 빠른순, 같다면 시작시간이 빠른순
        Collections.sort(list, (l1,l2)->{
            if(l1[1]==l2[1])
                return l1[0] - l2[0];//시작하는시간 빠른대로
            return l1[1] - l2[1]; //끝나는시간 빠른대로(오름차순)
        });

        int cnt = 0;
        int t = 0; //현재 시간
        for(int i=0; i<n; i++){
            if(t > list.get(i)[0]) continue; // 시작시간이 현재 시간보다 이전인 회의 무시
            cnt++; //시작시간이 현재 시간 이후인 회의 +1
            t = list.get(i)[1]; // 현재 시간을 선택된 회의의 끝나는 시간으로 변경
        }
        System.out.println(cnt);
    }
}