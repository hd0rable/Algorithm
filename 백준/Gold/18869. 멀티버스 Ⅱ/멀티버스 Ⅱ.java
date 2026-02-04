import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        List<Integer>[] sortedArray = new ArrayList[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();

            for(int j=0; j<n; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                set.add(num);
            }

            sortedArray[i] = new ArrayList<>(set);
            Collections.sort(sortedArray[i]);
       }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = Collections.binarySearch(sortedArray[i],arr[i][j]);
            }
        }

       int cnt =0;
       for(int i=0; i<m; i++){
           for(int j=i+1; j<m; j++){
               if(Arrays.equals(arr[i],arr[j])) cnt++;
           }
       }
        System.out.println(cnt);
    }

}