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
            sb.append(binarySearch(x)).append('\n');
        }
        System.out.println(sb);
    }

    static int binarySearch(int target){
        int start = 0;
        int end = n-1;
        while(start <= end){
            int middle = (start+end)/2;
            if(a[middle] > target)
                end = middle - 1;
            else if(a[middle] < target)
                start = middle + 1;
            else return 1;
        }
        return 0;
    }
}