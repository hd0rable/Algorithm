import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] sum = new int[3];
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            sum[i] = 0;
            for (int j = 0; j < 4; j++) {
                sum[i] += Integer.parseInt(st.nextToken());
            }
        }

        // 0 1개 1 3개 도 3 A
        // 0 2개 1 2개 개 2 B
        // 0 3개 1 1개 걸 1 C
        // 0 4개 윷 0 D
        // 1 4개 모 4 E
        for (int i=0; i<3; i++) {
            switch (sum[i]) {
                case 0:
                    System.out.println("D");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 4:
                    System.out.println("E");
                    break;
            }
        }
    }
}