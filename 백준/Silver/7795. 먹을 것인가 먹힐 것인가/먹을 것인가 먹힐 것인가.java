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

            Collections.sort(listA); // 1 1 3 7 8
            Collections.sort(listB); // 1 3 6

            int cnt = 0;
            for(int i=0; i<n; i++) {
                int num = listA.get(i);
                int min = listB.get(0);
                int max = listB.get(listB.size() - 1);
                if (num <= min) //현재 b보다 작거나 같아서 먹을수있는 먹이가 없음
                    continue;
                if (num > max) //b의 최대값보다 현재 a값이 큼
                    cnt += listB.size(); //b의 있는 모든 값을 먹을수있음
                else{ //b의 최대값보다는 a값이 작음
                    cnt ++;
                    for(int j=1; j<m-1; j++){
                        if(num > listB.get(j))
                            cnt++;
                        else break;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}