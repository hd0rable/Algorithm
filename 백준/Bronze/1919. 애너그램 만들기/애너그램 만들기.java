import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr1Str = br.readLine();
        String arr2Str = br.readLine();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i< arr1Str.length(); i++){
            arr1[arr1Str.charAt(i) - 'a']++;
        }
        for(int i = 0; i< arr2Str.length(); i++){
            arr2[arr2Str.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(arr1[i]!=arr2[i])
                count+= arr1[i]-arr2[i]>0 ? arr1[i]-arr2[i] : arr2[i]-arr1[i];
        }
        System.out.println(count);
    }
}