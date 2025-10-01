import java.io.*;
import java.util.*;

public class Main {

    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       N = Integer.parseInt(br.readLine());
       number = new int[N];

       // 숫자 입력
       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       for(int i = 0; i < N; i++){
           number[i] = Integer.parseInt(st.nextToken());
       }

       // 연산자 입력
       st = new StringTokenizer(br.readLine()," ");
       for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
       }

       dfs(number[0],1);

       System.out.println(MAX);
       System.out.println(MIN);
    }

    public static void dfs(int num, int index){
        if(index == N){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){

                // 해당 연산자 선택(연산자 수 감소)
                operator[i]--;

                switch (i){
                    case 0: dfs(num + number[index],index+1); break;
                    case 1: dfs(num - number[index],index+1); break;
                    case 2: dfs(num * number[index],index+1); break;
                    case 3: dfs(num / number[index],index+1); break;
                }

                // 재귀호출이 종료되면 해당 연산자 개수 복구
                operator[i]++;
            }
        }
    }
}