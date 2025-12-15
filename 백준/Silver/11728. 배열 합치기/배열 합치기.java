import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arrNM = new int[n+m];
        for(int i=0; i<n; i++)
            arrNM[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=n; i<n+m; i++)
            arrNM[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arrNM);
        for(int i=0; i<n+m; i++){
           sb.append(arrNM[i]).append(' ');
        }
        System.out.println(sb);
    }

}