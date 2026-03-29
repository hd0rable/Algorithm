import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizeArr = new int[6];
        for(int i=0; i<6; i++)
            sizeArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tCount = 0;
        for(int i=0; i<6; i++){
            tCount += sizeArr[i]/t;
            tCount = sizeArr[i]%t == 0 ? tCount : tCount+1;
        }
        System.out.println(tCount);

        System.out.print(n/p);
        System.out.print(' ');
        System.out.print(n%p);

    }
}