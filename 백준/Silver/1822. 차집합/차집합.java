//https://www.acmicpc.net/problem/1822
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        TreeSet<Integer> aSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nA; i++)
            aSet.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<nB; i++) {
            int num = Integer.parseInt(st.nextToken());
            aSet.remove(num);
        }

        sb.append(aSet.size()).append('\n');
        for(int num : aSet){
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

}