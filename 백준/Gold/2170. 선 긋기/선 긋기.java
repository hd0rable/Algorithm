import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<long[]> list = new ArrayList<>(); //x,y

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            list.add(new long[]{x,y});
        }

        //시작위치가 빠른순(오름차순)
        Collections.sort(list, Comparator.comparingLong(l -> l[0]));

        long sum = 0;
        long start = list.get(0)[0];
        long end = list.get(0)[1];

        for(int i=1; i<n; i++) {
            long[] cur = list.get(i);
            if (cur[0] > end && cur[1] > end) { //선이 끝날경우 길이 업데이트 후 선분 시작,끝 위치 갱신
                sum += (end - start);
                start = cur[0];
                end = cur[1];
            } else if (cur[0] >= start && cur[1] <= end)
                continue; //선이 겹치는경우
            else if (cur[0] >= start && cur[1] > end)
                end = cur[1]; //현재 선이 더 나중에 끝날경우 길이 갱신
        }
        System.out.println(sum + end - start);
    }
}