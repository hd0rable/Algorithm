import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String line = br.readLine();
        for(int i=0 ; i<line.length(); i++){
            arr[line.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}