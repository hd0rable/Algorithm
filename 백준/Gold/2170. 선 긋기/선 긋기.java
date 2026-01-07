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
            if (cur[0] <= end) { // 선이 이어지는 경우 (부분 겹침 포함)
                end = Math.max(end, cur[1]);
            } else { // 선이 완전히 끊긴 경우
                sum += (end - start);
                start = cur[0];
                end = cur[1];
            }
        }
        System.out.println(sum + end - start);
    }

}