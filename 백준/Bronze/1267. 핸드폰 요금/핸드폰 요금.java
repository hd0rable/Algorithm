import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum_y = 0;
        int sum_m = 0;
        for(int i = 0; i<N; i++){
            int s = Integer.parseInt(st.nextToken());
            sum_y += (s/30)*10 + 10;
            sum_m += (s/60)*15 + 15;
        }
        StringBuilder sb = new StringBuilder();

        int min = Math.min(sum_y, sum_m);
        if (sum_m == sum_y){
            sb.append("Y M");
        }
        else if (min == sum_y){
            sb.append("Y");
        }
        else sb.append("M");
        sb.append(" ").append(min);

        System.out.println(sb);
    }
}