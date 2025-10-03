import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()); //자바에서 int의 최대값이 10^9 정도
        long B = Long.parseLong(st.nextToken()); //입력의 최대값이 10^15이기 때문에 long
        StringBuilder sb = new StringBuilder();
        if (A > B){
            long temp = A;
            A = B;
            B = temp;
        }
        if (A == B)
            sb.append(0);
        else sb.append(B - A - 1).append("\n");
        for (long i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}