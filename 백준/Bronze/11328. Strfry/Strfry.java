import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            String arr1Str = st.nextToken();
            String arr2Str = st.nextToken();
            for(int j=0; j<arr1Str.length(); j++){
                arr1[arr1Str.charAt(j)-'a']++;
            }
            for(int j=0; j<arr2Str.length(); j++){
                arr2[arr2Str.charAt(j)-'a']++;
            }
            boolean possible = true;
            for(int j=0; j<26; j++){
                if(arr1[j] != arr2[j]){
                    possible = false;
                    sb.append("Impossible\n");
                    break;
                }
            }
            if(possible) sb.append("Possible\n");
        }
        System.out.println(sb);
    }
}