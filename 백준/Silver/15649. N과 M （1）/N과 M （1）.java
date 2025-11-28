import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n,m;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        func(0);
        System.out.println(sb);
    }

    static void func(int k){ // 현재 k개까지 수를 택함
        if(k == m){ // m개를 모두 택했으면
            for(int i=0; i<m; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
        }

        for(int i=1; i<=n; i++){
            if(!isUsed[i]){ // 아직 i가 사용되지 않았으면
                arr[k] = i; // k번째 수를 i로 정함
                isUsed[i] = true;  // i를 사용되었다고 표시
                func(k+1); // 다음 수를 정하러 한 단계 더 들어감
                isUsed[i] = false; // k번째 수를 i로 정한 모든 경우에 대해 다 확인했으니 i를 사용되지않았다고 명시
            }
        }
    }

}