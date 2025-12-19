import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t--> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();

            for (int i = 0; i < n; i++)
                listA.add(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                listB.add(Integer.parseInt(st.nextToken()));

            Collections.sort(listB);

            int cnt = 0;
            for(int i=0; i<n; i++) {
                int low = 0;
                int high = m-1;
                int index = 0;
                while(low <= high){
                    int mid = (low + high) /2 ;
                    if(listB.get(mid) < listA.get(i)){
                        low = mid + 1;
                        index = mid + 1;
                    }
                    else high = mid - 1;
                }
                cnt += index;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}