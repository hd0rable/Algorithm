//https://www.acmicpc.net/problem/18869
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

       int[][] sortedArray = new int[m][n];
       int[][] originalArray = new int[m][n];
       int[][] indexes = new int[m][n];
       for(int i=0; i<m; i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<n; j++){
               int num = Integer.parseInt(st.nextToken());
               originalArray[i][j] = sortedArray[i][j] = num;
           }
           Arrays.sort(sortedArray[i]);
       }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                indexes[i][j] =
                        Arrays.binarySearch(sortedArray[i],originalArray[i][j]);
            }
        }

       int cnt =0;
       for(int i=0; i<m; i++){
           for(int j=i+1; j<m; j++){
               if(Arrays.equals(indexes[i],indexes[j])) cnt++;
           }
       }
        System.out.println(cnt);
    }

}