//https://www.acmicpc.net/problem/18870
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            set.add(a[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i=0; i<n; i++){
            sb.append(Collections.binarySearch(list,a[i])).append(' ');
        }
        System.out.println(sb);
    }


}
