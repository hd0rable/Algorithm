//https://www.acmicpc.net/problem/2295
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        for(int i=0; i<n; i++)
            input[i] = Integer.parseInt(br.readLine());
        Arrays.sort(input);

        int[] two = new int[n*n+1];
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                two[index++] = input[i] + input[j];
            }
        }
        Arrays.sort(two);
        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(Arrays.binarySearch(two,input[i]-input[j]) > 0){
                    System.out.println(input[i]);
                    return;
                }
            }
        }
    }

}