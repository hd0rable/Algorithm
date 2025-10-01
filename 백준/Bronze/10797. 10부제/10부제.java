import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] car = new int[5];
        int count = 0;
        for (int i = 0; i < 5; i++) {
            car[i] = Integer.parseInt(st.nextToken());
            if (day == car[i])
                count++;
        }
        System.out.println(count);
    }
}