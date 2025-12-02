import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] n_arr;
    static boolean[] isUsed;
    static Set<String> set = new LinkedHashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        n_arr = new int[n];
        isUsed = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            n_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n_arr);
        func(0);
        set.forEach(System.out::println);
    }

    static void func(int k){
        if(k == m){
            String temp = "";
            for(int i=0; i<m; i++)
                temp += String.valueOf(arr[i]) + ' ';
            set.add(temp);
            return;
        }
        for(int i=0; i<n; i++){
            if(!isUsed[i]) {
                isUsed[i] = true;
                arr[k] = n_arr[i];
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}