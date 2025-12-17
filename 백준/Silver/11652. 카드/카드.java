import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for(int i=0; i<n; i++)
            arr[i] = Long.parseLong(br.readLine());

        Arrays.sort(arr);

        int max = -1; long maxNum = 0;
        int cnt = 1;
        for(int i=1; i<n; i++){
            if(arr[i-1] == arr[i]) cnt++;
            else {
                if (cnt > max){ //최대값이 같을때는 제일 처음에 나왔던 작은값이 갱신안되게
                    max = cnt;
                    maxNum = arr[i - 1];
                }
                cnt = 1;
            }
        }
        if(cnt > max) maxNum = arr[n-1];
        System.out.println(maxNum);
    }

}