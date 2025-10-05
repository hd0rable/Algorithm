import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // -100 ~ 100
        int[] arr = new int[201];
        for(int i = 0; i< N; i++){
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }
        int v = Integer.parseInt(br.readLine());
        System.out.println(arr[v+100]);

    }
}