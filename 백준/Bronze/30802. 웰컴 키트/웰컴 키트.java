import java.io.*;
import java.util.*;
public class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int xl = Integer.parseInt(st.nextToken());
        int xxl = Integer.parseInt(st.nextToken());
        int xxxl = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tCount = counting(s) + counting(m) + counting(l) +
                counting(xl) + counting(xxl) + counting(xxxl);
        System.out.println(tCount);

        System.out.print(n/p);
        System.out.print(' ');
        System.out.print(n%p);

    }

    static int counting(int size){
        if(size%t==0) return size/t;
        else return size/t+1;
    }

}
