import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0){
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperIdx(x,n)-lowerIdx(x,n)).append(' ');
        }
        System.out.println(sb);
    }

    static int lowerIdx(int target, int len){
        int st = 0;
        int en = len;
        while(st < en){
            int mid = (st+en)/2;
            if(a[mid] >= target) en = mid;
            else st = mid+1;
        }
        return st;
    }
    static int upperIdx(int target, int len){
        int st = 0;
        int en = len;
        while(st < en){
            int mid = (st+en)/2;
            if(a[mid] > target) en = mid;
            else st = mid+1;
        }
        return st;
    }
}