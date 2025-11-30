import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] isUsed1 = new boolean[40]; //열을 차지하고있는지
    static boolean[] isUsed2 = new boolean[40]; // / 방향 대각선을 차지하고있는지
    static boolean[] isUsed3 = new boolean[40]; // \ 방향 대각선을 차지하고있는지
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        func(0);
        System.out.println(cnt);
    }

    static void func(int cur){  //cur번째 행에 말 배치
        if(cur == n){ //n개의 말을 놓는데 성공했다면
            cnt++;
            return;
        }
        for(int i=0; i<n; i++){
            if(isUsed1[i] || isUsed2[i+cur] || isUsed3[cur-i+n-1])
                continue;
            isUsed1[i] = true;
            isUsed2[i+cur] = true;
            isUsed3[cur-i+n-1] = true;
            func(cur+1);
            isUsed1[i] = false;
            isUsed2[i+cur] = false;
            isUsed3[cur-i+n-1] = false;
        }
    }

}