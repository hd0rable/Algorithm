import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int k = 0;
    static int[] num;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        while(k!=0){
            num = new int[k];
            arr = new int[k];
            isUsed = new boolean[k];
            for(int i=0; i<k; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            func(0,0);
            sb.append('\n');

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    // at 사전순으로 출력하기위해 어디서부터 시작하는지 기억
    static void func(int cur, int at){
        if(cur == 6){
            for(int i=0; i<6; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=at; i<k; i++){
            if(!isUsed[i]) { //중복 선택안되고
                isUsed[i] = true;
                arr[cur] = num[i];
                func(cur + 1, i);
                isUsed[i] = false;
            }
        }
    }

}