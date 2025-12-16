import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a1,a2) -> {
            // 길이 오름차순 (짦은것이 먼저)
            if(a1.length() != a2.length())
                return a1.length() - a2.length();
            // 자리수의 합 오름차순
            int sum1 =0, sum2 =0;
            for(char c : a1.toCharArray()){
                if(c>='0'&& c<='9')
                    sum1 += c -'0';
            }
            for(char c : a2.toCharArray()){
                if(c>='0'&& c<='9')
                    sum2 += c -'0';
            }
            if(sum1 != sum2)
                return sum1 - sum2;

            //String의 기본 사전순 정렬
            else return a1.compareTo(a2);
        });
        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }

}