import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 사전 순으로 자동 정렬되는 TreeSet 사용
        TreeSet<String> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        // 역순으로 출력
        StringBuilder sb = new StringBuilder();
        for (String name : set.descendingSet()) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);

    }

}