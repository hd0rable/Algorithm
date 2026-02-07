import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long ans = 0;
        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            int target = -arr[i];
            while(left < right){
                int sum = arr[left] + arr[right];
                if(target == sum){
                    if(arr[left] == arr[right]){
                        int count = right - left + 1;
                        ans += (long) count * (count - 1) / 2;
                        break;
                    }
                    int lCnt = 1;
                    int rCnt = 1;

                    // 왼쪽이랑 똑같은 값이 몇 개인지 세기
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        lCnt++;
                        left++;
                    }
                    // 오른쪽이랑 똑같은 값이 몇 개인지 세기
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rCnt++;
                        right--;
                    }

                    ans += (long) lCnt * rCnt;
                    left++;
                    right--;
                }else if (sum < target)
                    left++;
                else right--;
            }
        }

        System.out.print(ans);
    }
}