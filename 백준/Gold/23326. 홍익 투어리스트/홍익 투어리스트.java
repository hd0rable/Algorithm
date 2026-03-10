import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++){
            if (Integer.parseInt(st.nextToken()) == 1) set.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int x = 0; //도현이의 위치
        while(q-->0){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch(cmd){
                case 1:
                    int index = Integer.parseInt(st.nextToken()) -1;
                    if(set.contains(index) && !set.isEmpty()) set.remove(index);
                    else set.add(index);
                    break;
                case 2:
                    int dx = Integer.parseInt(st.nextToken());
                    x = (x + dx) % n;
                    break;
                case 3:
                    if(set.isEmpty()) sb.append(-1);
                    else {
                        Integer target = set.ceiling(x);
                        if(target != null) sb.append(target - x);
                        else sb.append(n - x + set.first()); // 한 바퀴 돌아서 가장 작은 번호로
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
